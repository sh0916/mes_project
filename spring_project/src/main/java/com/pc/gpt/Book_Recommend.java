package com.pc.gpt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import io.github.bonigarcia.wdm.WebDriverManager;

public class Book_Recommend {

	// 뤼튼에게 요청하고 받아내기(gpt4.0,wrtn_search, 답변이 지멋대로라 안정성 매우 떨어짐)
	public String wrtn_qna(String query) {
		String result = "";
		try {
			String assi_data = "";
			String ai_model = "gpt4";
			long unixTime = System.currentTimeMillis();
			URL url_q = new URL(
					"https://william.wow.wrtn.ai/chat/anonymous/start?platform=web&mode=chat&model=" + ai_model);
			
			HttpURLConnection connection_q = (HttpURLConnection) url_q.openConnection();

			// 요청 헤더 설정
			configureConnection(connection_q, "" + unixTime, "POST");
			
			// POST 요청에 데이터를 포함시키기 위해 출력 스트림 활성화
			connection_q.setDoOutput(true);
			
			// 전송할 쿼리 준비 - 내 질문
			String jsonInputString_q = "{\"message\": \"" + query + "\"}";
			
			// 요청에 데이터 쓰기
			try {
				OutputStream os = connection_q.getOutputStream();
				byte[] input = jsonInputString_q.getBytes("utf-8");
				os.write(input, 0, input.length);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			// 응답 코드 확인
			int responseCode = connection_q.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			// 웹 페이지 내용 읽기(여기선 getInputStream때 connect 가 된다)
			BufferedReader in_q = new BufferedReader(new InputStreamReader(connection_q.getInputStream()));
			StringBuffer rs_q = new StringBuffer();
			String inputLine;

			// StringBuffer에 가져온 내용 모두 담아서
			while ((inputLine = in_q.readLine()) != null) {
				rs_q.append(inputLine);
			}
			in_q.close();
			
			connection_q.disconnect();
			
			
			// 응답 내용 출력
			System.out.println(rs_q.toString());
			
			assi_data = getDataOne(rs_q.toString(), "data\":\"", "\"");
			System.out.println(assi_data);
			
			System.out.println("POST 걸린시간 : " + (System.currentTimeMillis() - unixTime));

			// data값이 있다면 답을 가져오기(1단계, 일종의 답변요청)
			if (!"".equals(assi_data) && assi_data != null) {
				// 뤼튼에게 답 받아내기(한번 요청을 하고 나서야 아래 요청이 가능해진다)
				URL url_a = new URL("https://william.wow.wrtn.ai/chat/anonymous/" + assi_data + "?model=" + ai_model
						+ "&platform=web&user=nobody");
				
				HttpURLConnection connection_a = (HttpURLConnection) url_a.openConnection();
				// 헤더설정
				configureConnection(connection_a, "" + unixTime, "GET");
				// 응답 코드 확인(이걸 하면서 connect도 작동된다.)
				responseCode = connection_a.getResponseCode();
				System.out.println("Response Code: " + responseCode);
				System.out.println("GET1 단순한 응답완료 : " + (System.currentTimeMillis() - unixTime));

//				첫 번째 요청에서는 응답 본문을 사용하지 않으므로, 연결을 빠르게 종료
				connection_a.disconnect();
				System.out.println("GET1 걸린시간 : " + (System.currentTimeMillis() - unixTime));
			}
			// 최종적으로 정리된 내용을 받아오기위한 get
			if (!"".equals(assi_data) && assi_data != null) {
				for (int i = 0; i < 10; i++) {
					// 뤼튼에게 답 받아내기
					URL url_a = new URL("https://william.wow.wrtn.ai/chat/anonymous/" + assi_data + "/result");
					HttpURLConnection connection_a = (HttpURLConnection) url_a.openConnection();

					// 헤더설정
					configureConnection(connection_a, "" + unixTime, "GET");

					// 상태 확인
					responseCode = connection_a.getResponseCode();
					System.out.println("Response Code: " + responseCode);
					
					// 에러면 10초대기
					if (responseCode == 500) {
						System.out.println("아직 응답을 받지 못해 10초 대기합니다.");
						Thread.sleep(10000);
						continue;
					}
					// 웹 페이지 내용 읽기
					BufferedReader in_a = new BufferedReader(new InputStreamReader(connection_a.getInputStream()));
					StringBuffer rs_a = new StringBuffer();

					while ((inputLine = in_a.readLine()) != null) {
						rs_a.append(inputLine);
					}
					in_a.close();
					connection_a.disconnect();
					
					System.out.println("답변?" + rs_a.toString());
					result = getDataOne(rs_a.toString(), ",\"content\":\"", "\",\"status\"");

					System.out.println(result);
					System.out.println("GET2 걸린시간 : " + (System.currentTimeMillis() - unixTime));
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 헤더 설정을 위한 메소드(뤼튼)
	private void configureConnection(HttpURLConnection connection, String unixTime, String method)
			throws ProtocolException {
		connection.setRequestMethod(method);
		connection.setRequestProperty("Content-Type", "application/json");
//		connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		connection.setRequestProperty("host", "william.wow.wrtn.ai");
		connection.setRequestProperty("Referer", "https://wrtn.ai/");
		connection.setRequestProperty("wrtn-locale", "ko-KR");
		connection.setRequestProperty("x-wrtn-id",
				"W1.2.2501006464537361220005373612200051024128024.zD5VRxF2iPK1GWakz6wvd." + unixTime);
//		"W1.2.2501006464537361220005373612200051024128024.obV9sF_ZlFvDyD7GEfHR4." + unixTime);
//		connection.setRequestProperty("x-wrtn-id", "W1.2.2501006464537361220005373612200051024128024.obV9sF_ZlFvDyD7GEfHR4.1710747589240");
//		connection.setRequestProperty("x-wrtn-id", "W1.2.2501006464537361220005373612200051024128024.YXvD2j0myi8uUHCZ60lYR.1710806620964");
	}

	// 단어 잘라내는 메소드
	public String getDataOne(String source, String start, String endString) {
		int startIndex = source.indexOf(start);
		int endIndex;

		if (endString == null || endString.isEmpty()) {
			endIndex = source.length();
		} else {
			endIndex = source.indexOf(endString, startIndex + start.length());
			if (endIndex == -1) { // endString이 소스 내에 없는 경우, 소스 문자열의 끝까지를 지정
				endIndex = source.length();
			}
		}

		if (startIndex != -1) {
			// startIndex + start.length()를 해줌으로써, 시작 태그 바로 뒤의 위치를 얻습니다.
			// endIndex는 종료 태그의 시작 위치 또는 문자열의 끝이므로, 이 사이의 문자열을 추출합니다.
			return source.substring(startIndex + start.length(), endIndex);
		} else {
			return "";
		}
	}

	// 여러 개의 문자열을 추출하여 배열로 반환하는 메소드
	public String[] getDataList(String source, String start, String endString) {
		List<String> resultList = new ArrayList<String>();
		int startIndex = 0;
		int endIndex;

		while (true) {
			startIndex = source.indexOf(start, startIndex);
			if (startIndex == -1)
				break; // 더 이상 시작 문자열을 찾을 수 없으면 반복 종료

			endIndex = source.indexOf(endString, startIndex + start.length());
			if (endIndex == -1) {
				endIndex = source.length();
			}

			// 문자열 추출 및 리스트에 추가
			String extracted = source.substring(startIndex + start.length(), endIndex);
			resultList.add(extracted);

			// 다음 검색을 위해 startIndex 업데이트
			startIndex = endIndex + endString.length();
		}

		// 결과 리스트를 배열로 변환하여 반환
		return resultList.toArray(new String[0]);
	}
}

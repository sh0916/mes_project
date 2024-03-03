package workOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkOrderDAO {

	public List selectTable(String local) {
		List list = new ArrayList();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";		
		String user = "scott4_4";
		String password = "tiger";
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			String query = "";
			
			if( local.equals("/workOrder") ) {
				
				query += " SELECT"
						+ " w_seq, w_title, w_detail, url";
				query += " FROM"
						+ " workTable";
				query += " WHERE"
						+ " type = 1";
			} else if( local.equals("/workSafety") ) {
				
				query += " SELECT"
						+ " w_seq, w_title, w_detail, url";
				query += " FROM"
						+ " workTable";
				query += " WHERE"
						+ " type = 2";
			} else if( local.equals("/workQuality") ) {
				
				query += " SELECT"
						+ " w_seq, w_title, w_detail, url";
				query += " FROM"
						+ " workTable";
				query += " WHERE"
						+ " type = 3"
						+ " OR"
						+ " w_seq = 69";
			}
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				int seq = rs.getInt(1);
				String title = rs.getString(2);
				String detail = rs.getString(3);
				String urlImage = rs.getString(4);
				
				WorkOrderDTO dto = new WorkOrderDTO();
				dto.setSeq(seq);
				dto.setTitle(title);
				dto.setDetail(detail);
				dto.setUrlImage(urlImage);
				
				list.add(dto);
			}
			
			if( local.equals("/workQuality") ) {
				
				query = "";
				query += " SELECT"
						+ " id, line, model, hire_date";
				query += " FROM"
						+ " goods";
				
				PreparedStatement ps2 = con.prepareStatement(query);
				ResultSet rs2 = ps2.executeQuery();
				 
				 while( rs2.next() ) {
					 
					 int goodsSeq = rs2.getInt(1);
					 int line = rs2.getInt(2);
					 String model = rs2.getString(3);
					 Date date = rs2.getDate(4);
					 
					 // Date 타입을 문자열로 변환
					 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					 String hireDate = format.format(date);
					 
					 WorkOrderDTO dto = new WorkOrderDTO();
					 dto.setGoodsSeq(goodsSeq);
					 dto.setLine(line);
					 dto.setModel(model);
					 dto.setHireDate(hireDate);
					 System.out.println(line + model + hireDate);
					 list.add(dto);
				 }
				 
				rs2.close();
				ps2.close();
			}
			
			
			rs.close();
			ps.close();		
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertInfo(WorkOrderDTO dto, String local) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";		
		String user = "scott4_4";
		String password = "tiger";
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			String title = dto.getTitle();
			String detail = dto.getDetail();
			String urlImage = dto.getUrlImage();
			
			int facilitySeq = dto.getFacilitySeq();
			String facilityDetail = dto.getFacilityDetail();
			String sendTime = dto.getSendTime();
			
			// 날짜타입으로 형변환
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime time = LocalDateTime.parse(sendTime, format);

			
			if( local.equals("/workOrder") ) {
				
				detail = detail.replace(System.lineSeparator(), "\\n");
			} else if( local.equals("/workSafety") || local.equals("/workQuality") ) {
				
				detail = "- " + detail.replace(System.lineSeparator(), "\\n- ");
			}

			String query = "";
			
			if( local.equals("/workOrder") ) {
				
				query += " INSERT INTO"
						+ " workTable(w_seq, w_title, w_detail, url, type)";
				query += " VALUES"
						+ " ("
						+ " w_sequence.NEXTVAL, '"
						+ title
						+ "','"
						+ detail
						+ "','"
						+ urlImage
						+ "',"
						+ " 1"
						+ ")";
			} else if( local.equals("/workSafety") ) {
				
				query += " INSERT INTO"
						+ " workTable(w_seq, w_title, w_detail, url, type)";
				query += " VALUES"
						+ " ("
						+ " w_sequence.NEXTVAL, '"
						+ title
						+ "','"
						+ detail
						+ "','"
						+ urlImage
						+ "',"
						+ " 2"
						+ ")";
			} else if( local.equals("/workQuality") ) {
				
				query += " INSERT INTO"
						+ " workTable(w_seq, w_title, w_detail, type)";
				query += " VALUES"
						+ " ("
						+ " w_sequence.NEXTVAL, '"
						+ title
						+ "','"
						+ detail
						+ "',"
						+ " 3"
						+ ")";
			} else if( local.equals("/facilityUpdate") ) {
				
				query += " INSERT INTO"
						+ " finished(seq, error, facilty_seq, hire_date)";
				query += " VALUES"
						+ " ("
						+ " finished_SEQ.NEXTVAL, '"
						+ facilityDetail
						+ "','"
						+ facilitySeq
						+ "','"
						+ sendTime 
			            + "')";
			}
			
			PreparedStatement ps = con.prepareStatement(query);
			try {
				
				ps.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			}

			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteColumn(WorkOrderDTO dto) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";		
		String user = "scott4_4";
		String password = "tiger";
		
		try {
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			int seq = dto.getSeq();
			
			String query = "";

			query += " DELETE FROM"
					+ " workTable";
			query += " WHERE"
					+ " w_seq =";
			query += seq;
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeQuery();

			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void retouchColumn(WorkOrderDTO dto) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";		
		String user = "scott4_4";
		String password = "tiger";
		
		try {
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			
			int seq = dto.getSeq();
			String title = dto.getTitle();
			String detail = dto.getDetail();
			String urlImage = dto.getUrlImage();
			
			String query = "";
			
				query += " UPDATE"
						+ " workTable";
				query += " SET"
						+ " w_title = '"
						+ title
						+ "',"
						+ " w_detail = '"
						+ detail
						+ "',"
						+ " url = '"
						+ urlImage
						+ "'";
				query += " WHERE"
						+ " w_seq = "
						+ seq;
						
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeQuery();

			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

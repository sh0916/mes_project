package com.mes.project.jjh.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


public class Rodi_DTO {

	int mesId;
	String mesName;
	String mesGrade;
	String mesContent;
	int mesPrice;
	int gCount;
	String gLoc;
	public int getgCount() {
		return gCount;
	}

	public void setgCount(int gCount) {
		this.gCount = gCount;
	}

	@Override
	public String toString() {
		return "Rodi_DTO [mesId=" + mesId + ", mesName=" + mesName + ", mesGrade=" + mesGrade + ", mesContent="
				+ mesContent + ", mesPrice=" + mesPrice + ", gCount=" + gCount + ", gLoc=" + gLoc + ", bCount=" + bCount
				+ ", bLoc=" + bLoc + ", itemName=" + itemName + ", itemCount=" + itemCount + ", de_number=" + de_number
				+ ", s_number=" + s_number + ", co_number=" + co_number + ", de_date=" + de_date + ", de_content="
				+ de_content + ", de_result=" + de_result + ", de_etc=" + de_etc + ", mesGradeSerch=" + mesGradeSerch
				+ ", userInfo=" + userInfo + ", itemImg=" + itemImg + ", imgFileName=" + imgFileName + ", mesid="
				+ mesid + ", 품목=" + 품목 + ", 물품설명1=" + 물품설명1 + ", 물품설명2=" + 물품설명2 + ", 양품수량=" + 양품수량 + ", 양품재고위치="
				+ 양품재고위치 + ", 불량수량=" + 불량수량 + ", 불량재고위치=" + 불량재고위치 + ", 재고신청내역=" + 재고신청내역 + ", 수량=" + 수량 + ", 불량재고신청내역="
				+ 불량재고신청내역 + ", 불량신청수량=" + 불량신청수량 + ", 불량사유=" + 불량사유 + ", 기타입력사항=" + 기타입력사항 + "]";
	}

	public String getgLoc() {
		return gLoc;
	}

	public void setgLoc(String gLoc) {
		this.gLoc = gLoc;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}

	public String getbLoc() {
		return bLoc;
	}

	public void setbLoc(String bLoc) {
		this.bLoc = bLoc;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public Date getDe_date() {
		return de_date;
	}

	public void setDe_date(Date de_date) {
		this.de_date = de_date;
	}

	public String getMesGradeSerch() {
		return mesGradeSerch;
	}

	public void setMesGradeSerch(String mesGradeSerch) {
		this.mesGradeSerch = mesGradeSerch;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public MultipartFile getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(MultipartFile imgFileName) {
		this.imgFileName = imgFileName;
	}

	int bCount;
	String bLoc;

	String itemName;
	int itemCount;
	
	int de_number;
	int s_number;
	int co_number;
	Date de_date;
	String de_content;
	String de_result;
	String de_etc;
	String mesGradeSerch;
	String userInfo;
	
	
	String itemImg;
	MultipartFile imgFileName;
	

	public int getDe_number() {
		return de_number;
	}

	public void setDe_number(int de_number) {
		this.de_number = de_number;
	}

	public int getS_number() {
		return s_number;
	}

	public void setS_number(int s_number) {
		this.s_number = s_number;
	}

	public int getCo_number() {
		return co_number;
	}

	public void setCo_number(int co_number) {
		this.co_number = co_number;
	}



	public String getDe_content() {
		return de_content;
	}

	public void setDe_content(String de_content) {
		this.de_content = de_content;
	}

	public String getDe_result() {
		return de_result;
	}

	public void setDe_result(String de_result) {
		this.de_result = de_result;
	}

	public String getDe_etc() {
		return de_etc;
	}

	public void setDe_etc(String de_etc) {
		this.de_etc = de_etc;
	}

	public int getMesId() {
		return mesId;
	}

	public void setMesId(int mesId) {
		this.mesId = mesId;
	}

	public String getMesName() {
		return mesName;
	}

	public void setMesName(String mesName) {
		this.mesName = mesName;
	}

	public String getMesGrade() {
		return mesGrade;
	}

	public void setMesGrade(String mesGrade) {
		this.mesGrade = mesGrade;
	}

	public String getMesContent() {
		return mesContent;
	}

	public void setMesContent(String mesContent) {
		this.mesContent = mesContent;
	}

	public int getMesPrice() {
		return mesPrice;
	}

	public void setMesPrice(int mesPrice) {
		this.mesPrice = mesPrice;
	}

	public int getGCount() {
		return gCount;
	}

	public void setGCount(int gCount) {
		this.gCount = gCount;
	}

	public String getGLoc() {
		return gLoc;
	}

	public void setGLoc(String gLoc) {
		this.gLoc = gLoc;
	}

	public int getBCount() {
		return bCount;
	}

	public void setBCount(int bCount) {
		this.bCount = bCount;
	}

	public String getBLoc() {
		return bLoc;
	}

	public void setBLoc(String bLoc) {
		this.bLoc = bLoc;
	}

	int mesid;
	String 품목;
	String 물품설명1;
	String 물품설명2;
	int 양품수량;
	String 양품재고위치;
	int 불량수량;
	String 불량재고위치;

	String 재고신청내역;
	int 수량;

	String 불량재고신청내역;
	int 불량신청수량;

	String 불량사유;
	String 기타입력사항;

	public String get불량사유() {
		return 불량사유;
	}

	public void set불량사유(String 불량사유) {
		this.불량사유 = 불량사유;
	}

	public String get기타입력사항() {
		return 기타입력사항;
	}

	public void set기타입력사항(String 기타입력사항) {
		this.기타입력사항 = 기타입력사항;
	}

	public String get불량재고신청내역() {
		return 불량재고신청내역;
	}

	public void set불량재고신청내역(String 불량재고신청내역) {
		this.불량재고신청내역 = 불량재고신청내역;
	}

	public int get불량신청수량() {
		return 불량신청수량;
	}

	public void set불량신청수량(int 불량신청수량) {
		this.불량신청수량 = 불량신청수량;
	}

	public String get재고신청내역() {
		return 재고신청내역;
	}

	public void set재고신청내역(String 재고신청내역) {
		this.재고신청내역 = 재고신청내역;
	}

	public int get수량() {
		return 수량;
	}

	public void set수량(int 수량) {
		this.수량 = 수량;
	}

	public int getMesid() {
		return mesid;
	}

	public void setMesid(int mesid) {
		this.mesid = mesid;
	}

	public String get물품설명1() {
		return 물품설명1;
	}

	public void set물품설명1(String 물품설명1) {
		this.물품설명1 = 물품설명1;
	}

	public String get물품설명2() {
		return 물품설명2;
	}

	public void set물품설명2(String 물품설명2) {
		this.물품설명2 = 물품설명2;
	}

	public String get품목() {
		return 품목;
	}

	public void set품목(String 품목) {
		this.품목 = 품목;
	}

	public int get양품수량() {
		return 양품수량;
	}

	public void set양품수량(int 양품수량) {
		this.양품수량 = 양품수량;
	}

	public String get양품재고위치() {
		return 양품재고위치;
	}

	public void set양품재고위치(String 양품재고위치) {
		this.양품재고위치 = 양품재고위치;
	}

	public int get불량수량() {
		return 불량수량;
	}

	public void set불량수량(int 불량수량) {
		this.불량수량 = 불량수량;
	}

	public String get불량재고위치() {
		return 불량재고위치;
	}

	public void set불량재고위치(String 불량재고위치) {
		this.불량재고위치 = 불량재고위치;
	}
}

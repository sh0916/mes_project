package com.mes.project.jjh.dto;

import java.util.Date;

import lombok.Data;


public class Sr_DTO {

	int mesId;
	String mesName;
	String mesGrade;
	String mesContent;
	int mesPrice;
	int gCount;
	String gLoc;
	int bCount;
	String bLoc;
	Date orderData;
	Date adminOrderData;
	
	int orderNumber;

	String userInfo;
	
	String mesGradeSerch;
	String orderingName;
	
	int co_Number;
	int orderQuantity;
	String orderStatus;
	String userRole;
	
	
	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public int getCo_Number() {
		return co_Number;
	}

	public void setCo_Number(int co_Number) {
		this.co_Number = co_Number;
	}

	
	
	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
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
	public int getgCount() {
		return gCount;
	}

	public void setgCount(int gCount) {
		this.gCount = gCount;
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

	public Date getOrderData() {
		return orderData;
	}

	public void setOrderData(Date orderData) {
		this.orderData = orderData;
	}

	public Date getAdminOrderData() {
		return adminOrderData;
	}

	public void setAdminOrderData(Date adminOrderData) {
		this.adminOrderData = adminOrderData;
	}

	public String getMesGradeSerch() {
		return mesGradeSerch;
	}

	public void setMesGradeSerch(String mesGradeSerch) {
		this.mesGradeSerch = mesGradeSerch;
	}

	public String getOrderingName() {
		return orderingName;
	}

	public void setOrderingName(String orderingName) {
		this.orderingName = orderingName;
	}

	int 불량수량;
	String 불량재고위치;
	String 재고신청내역;
	int 수량;
	int 신청번호;







	public int getMesid() {
		return mesid;
	}

	public void setMesid(int mesid) {
		this.mesid = mesid;
	}

	public String get품목() {
		return 품목;
	}

	public void set품목(String 품목) {
		this.품목 = 품목;
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

	public int get신청번호() {
		return 신청번호;
	}

	public void set신청번호(int 신청번호) {
		this.신청번호 = 신청번호;
	}

	@Override
	public String toString() {
		return "Sr_DTO [mesId=" + mesId + ", mesName=" + mesName + ", mesGrade=" + mesGrade + ", mesContent="
				+ mesContent + ", mesPrice=" + mesPrice + ", gCount=" + gCount + ", gLoc=" + gLoc + ", bCount=" + bCount
				+ ", bLoc=" + bLoc + ", orderData=" + orderData + ", adminOrderData=" + adminOrderData
				+ ", orderNumber=" + orderNumber + ", userInfo=" + userInfo + ", mesGradeSerch=" + mesGradeSerch
				+ ", orderingName=" + orderingName + ", co_Number=" + co_Number + ", orderQuantity=" + orderQuantity
				+ ", orderStatus=" + orderStatus + ", userRole=" + userRole + ", mesid=" + mesid + ", 품목=" + 품목
				+ ", 물품설명1=" + 물품설명1 + ", 물품설명2=" + 물품설명2 + ", 양품수량=" + 양품수량 + ", 양품재고위치=" + 양품재고위치 + ", 불량수량=" + 불량수량
				+ ", 불량재고위치=" + 불량재고위치 + ", 재고신청내역=" + 재고신청내역 + ", 수량=" + 수량 + ", 신청번호=" + 신청번호 + "]";
	}

	
	
	
	
}

package com.pc.emp.dto;

public class WorkOrderDTO {

	int seq;
	String title;
	String detail;
	String urlImage;
	
	int goodsSeq;
	int line;
	String model;
	String hireDate;
	int quantity;
	
	int facilitySeq;
	String facilityDetail;
	String sendTime;
	int unclear;
	
	int workerId;
	String workerName;
	String workerTel;
	String workerEmail;
	/**
	 * @return the urlImage
	 */
	public String getUrlImage() {
		return urlImage;
	}
	/**
	 * @param urlImage the urlImage to set
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	/**
	 * @return the seq
	 */
	public int getSeq() {
		return seq;
	}
	/**
	 * @param seq the seq to set
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	/**
	 * @return the title
	 */ 
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public int getGoodsSeq() {
		return goodsSeq;
	}
	
	public void setGoodsSeq(int goodsSeq) {
		this.goodsSeq = goodsSeq;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public int getLine() {
		return line;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getHireDate() {
		return hireDate;
	}
	
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getFacilitySeq() {
		return facilitySeq;
	}
	
	public void setFacilitySeq(int facilitySeq) {
		this.facilitySeq = facilitySeq;
	}
	
	public String getFacilityDetail() {
		return facilityDetail;
	}
	
	public void setFacilityDetail(String facilityDetail) {
		this.facilityDetail = facilityDetail;
	}
	
	public String getSendTime() {
		return sendTime;
	}
	
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
	/**
	 * @return the unclear
	 */
	public int getUnclear() {
		return unclear;
	}
	/**
	 * @param unclear the unclear to set
	 */
	public void setUnclear(int unclear) {
		this.unclear = unclear;
	}
	/**
	 * @return the workerId
	 */
	public int getWorkerId() {
		return workerId;
	}
	/**
	 * @param workerId the workerId to set
	 */
	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}
	/**
	 * @return the workerName
	 */
	public String getWorkerName() {
		return workerName;
	}
	/**
	 * @param workerName the workerName to set
	 */
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	/**
	 * @return the workerTel
	 */
	public String getWorkerTel() {
		return workerTel;
	}
	/**
	 * @param workerTel the workerTel to set
	 */
	public void setWorkerTel(String workerTel) {
		this.workerTel = workerTel;
	}
	/**
	 * @return the workEmail
	 */
	public String getWorkerEmail() {
		return workerEmail;
	}
	/**
	 * @param workEmail the workEmail to set
	 */
	public void setWorkerEmail(String workEmail) {
		this.workerEmail = workEmail;
	}
	@Override
	public String toString() {
		return "WorkOrderDTO [seq=" + seq + ", title=" + title + ", detail=" + detail + "]";
	}
	
}

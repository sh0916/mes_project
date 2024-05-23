package com.mes.project.ldy.dto;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class StockDTO {
	int stockNum;
	List<SD_DTO> stockName;
	int stockCount;
	String stockID;
	String g_grade;
	
	int lineNum;
	Timestamp startTime;
	Timestamp endTime;
	
	int product;
	
	int pass;
	int fail;
	int g_sequence;
	int qualitychk;
	public int getStockNum() {
		return stockNum;
	}
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	public List<SD_DTO> getStockName() {
		return stockName;
	}
	public void setStockName(List<SD_DTO> stockName) {
		this.stockName = stockName;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public String getStockID() {
		return stockID;
	}
	public void setStockID(String stockID) {
		this.stockID = stockID;
	}
	public String getG_grade() {
		return g_grade;
	}
	public void setG_grade(String g_grade) {
		this.g_grade = g_grade;
	}
	public int getLineNum() {
		return lineNum;
	}
	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}
	public int getG_sequence() {
		return g_sequence;
	}
	public void setG_sequence(int g_sequence) {
		this.g_sequence = g_sequence;
	}
	public int getQualitychk() {
		return qualitychk;
	}
	public void setQualitychk(int qualitychk) {
		this.qualitychk = qualitychk;
	}
	@Override
	public String toString() {
		return "StockDTO [stockNum=" + stockNum + ", stockName=" + stockName + ", stockCount=" + stockCount
				+ ", stockID=" + stockID + ", g_grade=" + g_grade + ", lineNum=" + lineNum + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", product=" + product + ", pass=" + pass + ", fail=" + fail
				+ ", g_sequence=" + g_sequence + ", qualitychk=" + qualitychk + ", getStockNum()=" + getStockNum()
				+ ", getStockName()=" + getStockName() + ", getStockCount()=" + getStockCount() + ", getStockID()="
				+ getStockID() + ", getG_grade()=" + getG_grade() + ", getLineNum()=" + getLineNum()
				+ ", getStartTime()=" + getStartTime() + ", getEndTime()=" + getEndTime() + ", getProduct()="
				+ getProduct() + ", getPass()=" + getPass() + ", getFail()=" + getFail() + ", getG_sequence()="
				+ getG_sequence() + ", getQualitychk()=" + getQualitychk() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}

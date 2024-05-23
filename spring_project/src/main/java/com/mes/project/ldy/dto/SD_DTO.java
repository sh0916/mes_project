package com.mes.project.ldy.dto;


import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class SD_DTO {
	int lineNum;
	String stockType;
	String stockName;
	int stockCount;
	public int getLineNum() {
		return lineNum;
	}
	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	@Override
	public String toString() {
		return "SD_DTO [lineNum=" + lineNum + ", stockType=" + stockType + ", stockName=" + stockName + ", stockCount="
				+ stockCount + ", getLineNum()=" + getLineNum() + ", getStockType()=" + getStockType()
				+ ", getStockName()=" + getStockName() + ", getStockCount()=" + getStockCount() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}

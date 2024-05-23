package com.mes.project.ldy.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class Qr_DTO {
	String fileName;
	String data;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Qr_DTO [fileName=" + fileName + ", data=" + data + ", getFileName()=" + getFileName() + ", getData()="
				+ getData() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}

package com.mes.project.ktw.staff.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Component

public class AbsentDTO {
	int staffno;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	Date start_date;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	Date end_date;
	
	String reason;
	String status;
	String sortOrder = "ASC";
	String sortField = "staffno";
	int typeNumber = 1;
	int size = 10;
	int page = 1;
	int id;
	int start;
	int end;
	int rnum;
	public int getStaffno() {
		return staffno;
	}
	public void setStaffno(int staffno) {
		this.staffno = staffno;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public int getTypeNumber() {
		return typeNumber;
	}
	public void setTypeNumber(int typeNumber) {
		this.typeNumber = typeNumber;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "AbsentDTO [staffno=" + staffno + ", start_date=" + start_date + ", end_date=" + end_date + ", reason="
				+ reason + ", status=" + status + ", sortOrder=" + sortOrder + ", sortField=" + sortField
				+ ", typeNumber=" + typeNumber + ", size=" + size + ", page=" + page + ", id=" + id + ", start=" + start
				+ ", end=" + end + ", rnum=" + rnum + ", getStaffno()=" + getStaffno() + ", getStart_date()="
				+ getStart_date() + ", getEnd_date()=" + getEnd_date() + ", getReason()=" + getReason()
				+ ", getStatus()=" + getStatus() + ", getSortOrder()=" + getSortOrder() + ", getSortField()="
				+ getSortField() + ", getTypeNumber()=" + getTypeNumber() + ", getSize()=" + getSize() + ", getPage()="
				+ getPage() + ", getId()=" + getId() + ", getStart()=" + getStart() + ", getEnd()=" + getEnd()
				+ ", getRnum()=" + getRnum() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}

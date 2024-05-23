package com.mes.project.ldy.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Component
public class BoardDTO {

	int b_sequence;
	String b_title;
	String b_content;
	int staffno;
	Timestamp b_date;
	int b_view;
	String boardType;
	String fileName;
	int replyId;
	
	
	String sname;
	MultipartFile imgFileName;

	int pageNum;
	int countPerPage;
	
	int startColumn;
	int endColumn;
	
	int LEVEL;

	public int getB_sequence() {
		return b_sequence;
	}

	public void setB_sequence(int b_sequence) {
		this.b_sequence = b_sequence;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public int getStaffno() {
		return staffno;
	}

	public void setStaffno(int staffno) {
		this.staffno = staffno;
	}

	public Timestamp getB_date() {
		return b_date;
	}

	public void setB_date(Timestamp b_date) {
		this.b_date = b_date;
	}

	public int getB_view() {
		return b_view;
	}

	public void setB_view(int b_view) {
		this.b_view = b_view;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public MultipartFile getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(MultipartFile imgFileName) {
		this.imgFileName = imgFileName;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getStartColumn() {
		return startColumn;
	}

	public void setStartColumn(int startColumn) {
		this.startColumn = startColumn;
	}

	public int getEndColumn() {
		return endColumn;
	}

	public void setEndColumn(int endColumn) {
		this.endColumn = endColumn;
	}

	public int getLEVEL() {
		return LEVEL;
	}

	public void setLEVEL(int lEVEL) {
		LEVEL = lEVEL;
	}

	@Override
	public String toString() {
		return "BoardDTO [b_sequence=" + b_sequence + ", b_title=" + b_title + ", b_content=" + b_content + ", staffno="
				+ staffno + ", b_date=" + b_date + ", b_view=" + b_view + ", boardType=" + boardType + ", fileName="
				+ fileName + ", replyId=" + replyId + ", sname=" + sname + ", imgFileName=" + imgFileName + ", pageNum="
				+ pageNum + ", countPerPage=" + countPerPage + ", startColumn=" + startColumn + ", endColumn="
				+ endColumn + ", LEVEL=" + LEVEL + ", getB_sequence()=" + getB_sequence() + ", getB_title()="
				+ getB_title() + ", getB_content()=" + getB_content() + ", getStaffno()=" + getStaffno()
				+ ", getB_date()=" + getB_date() + ", getB_view()=" + getB_view() + ", getBoardType()=" + getBoardType()
				+ ", getFileName()=" + getFileName() + ", getReplyId()=" + getReplyId() + ", getSname()=" + getSname()
				+ ", getImgFileName()=" + getImgFileName() + ", getPageNum()=" + getPageNum() + ", getCountPerPage()="
				+ getCountPerPage() + ", getStartColumn()=" + getStartColumn() + ", getEndColumn()=" + getEndColumn()
				+ ", getLEVEL()=" + getLEVEL() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}

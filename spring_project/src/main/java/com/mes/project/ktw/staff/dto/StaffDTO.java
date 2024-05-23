package com.mes.project.ktw.staff.dto;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Component

public class StaffDTO {
	private Role role;
	private String userid;
	private String password;
	private String sname;
	private int staffno;
	private int offino;
	private int sal;
	private int rnum;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hiredate;

	private String sduty;
	private String smail;
	private String sphone;
	
	public void setRole(Role role) {
		if (role == null) {
			this.role = Role.UNDEFINED;
		} else {
			this.role = role;
		}

	}
	
	public void setHireDate(String hireDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date parsedDate = dateFormat.parse(hireDate);
			this.hiredate = new Date(parsedDate.getTime());
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format provided, expected yyyy-MM-dd", e);
		}
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getStaffno() {
		return staffno;
	}

	public void setStaffno(int staffno) {
		this.staffno = staffno;
	}

	public int getOffino() {
		return offino;
	}

	public void setOffino(int offino) {
		this.offino = offino;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getSduty() {
		return sduty;
	}

	public void setSduty(String sduty) {
		this.sduty = sduty;
	}

	public String getSmail() {
		return smail;
	}

	public void setSmail(String smail) {
		this.smail = smail;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "StaffDTO [role=" + role + ", userid=" + userid + ", password=" + password + ", sname=" + sname
				+ ", staffno=" + staffno + ", offino=" + offino + ", sal=" + sal + ", rnum=" + rnum + ", hiredate="
				+ hiredate + ", sduty=" + sduty + ", smail=" + smail + ", sphone=" + sphone + ", getUserid()="
				+ getUserid() + ", getPassword()=" + getPassword() + ", getSname()=" + getSname() + ", getStaffno()="
				+ getStaffno() + ", getOffino()=" + getOffino() + ", getSal()=" + getSal() + ", getRnum()=" + getRnum()
				+ ", getHiredate()=" + getHiredate() + ", getSduty()=" + getSduty() + ", getSmail()=" + getSmail()
				+ ", getSphone()=" + getSphone() + ", getRole()=" + getRole() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}

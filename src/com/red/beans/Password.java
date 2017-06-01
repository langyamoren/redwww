package com.red.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Password implements Serializable 
{
	private static final long serialVersionUID = 4735335929893122666L;
    private Integer id;
    private Member member;
    private String pwdType;
    private String comCode;
    private String passwd;
    private Timestamp dates;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getPwdType() {
		return pwdType;
	}
	public void setPwdType(String pwdType) {
		this.pwdType = pwdType;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Timestamp getDates() {
		return dates;
	}
	public void setDates(Timestamp dates) {
		this.dates = dates;
	}

    
    
}

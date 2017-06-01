package com.red.beans;

import java.sql.Timestamp;

/**
 * Member entity. @author MyEclipse Persistence Tools
 */

public class Member implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 3836129008801557883L;
	private Integer id;
	private Memberlevel memberlevel;
	private Member member;
	private String email;
	private String password;
	private String name;
	private String qq;
	private String cellphone;
	private Integer integal;
	private String acount;
	private Byte acountType;
	private Integer balance;
	private Timestamp dates;
	private byte islock;
	private String privileges;
	// Constructors

	/** default constructor */
	public Member() {
	}

	/** minimal constructor */
	public Member(String email, String password, String name, String qq,
			String cellphone, Timestamp dates) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.qq = qq;
		this.cellphone = cellphone;
		this.dates = dates;
		
	}

	
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Memberlevel getMemberlevel() {
		return this.memberlevel;
	}

	public void setMemberlevel(Memberlevel memberlevel) {
		this.memberlevel = memberlevel;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Integer getIntegal() {
		return this.integal;
	}

	public void setIntegal(Integer integal) {
		this.integal = integal;
	}

	public String getAcount() {
		return this.acount;
	}

	public void setAcount(String acount) {
		this.acount = acount;
	}

	public Byte getAcountType() {
		return this.acountType;
	}

	public void setAcountType(Byte acountType) {
		this.acountType = acountType;
	}

	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Timestamp getDates() {
		return this.dates;
	}

	public void setDates(Timestamp dates) {
		this.dates = dates;
	}




	public byte getIslock() {
		return islock;
	}

	public void setIslock(byte islock) {
		this.islock = islock;
	}

	
	public String getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

}
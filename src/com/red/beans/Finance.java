package com.red.beans;

import java.sql.Timestamp;

/**
 * Finance entity. @author MyEclipse Persistence Tools
 */

public class Finance implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1164308826691326718L;
	private Integer id;
	private Member member;
	private Integer fromId;
	private Integer money;
	private Byte payType;
	private String descs;
	private Timestamp dates;
	private String orderAccount;

	// Constructors

	/** default constructor */
	public Finance() {
	}

	/** minimal constructor */
	public Finance(Integer money, Timestamp dates) {
		this.money = money;
		this.dates = dates;
	}

	/** full constructor */
	public Finance(Member member, Integer fromId, Integer money,
			Byte payType, String descs, Timestamp dates, String orderAccount) {
		this.member = member;
		this.fromId = fromId;
		this.money = money;
		this.payType = payType;
		this.descs = descs;
		this.dates = dates;
		this.orderAccount = orderAccount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Integer getFromId() {
		return this.fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public Integer getMoney() {
		return this.money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Byte getPayType() {
		return this.payType;
	}

	public void setPayType(Byte payType) {
		this.payType = payType;
	}

	public String getDescs() {
		return this.descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public Timestamp getDates() {
		return this.dates;
	}

	public void setDates(Timestamp dates) {
		this.dates = dates;
	}

	public String getOrderAccount() {
		return this.orderAccount;
	}

	public void setOrderAccount(String orderAccount) {
		this.orderAccount = orderAccount;
	}

}
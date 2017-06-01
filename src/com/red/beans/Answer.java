package com.red.beans;

import java.sql.Timestamp;

/**
 * Answer entity. @author MyEclipse Persistence Tools
 */

public class Answer implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 9063921985416875577L;
	private Integer id;
	private Member member;
	private Question question;
	private String descs;
	private Timestamp dates;

	// Constructors

	/** default constructor */
	public Answer() {
	}

	/** minimal constructor */
	public Answer(Timestamp dates) {
		this.dates = dates;
	}

	/** full constructor */
	public Answer(Member member, Question question, String descs, Timestamp dates) {
		this.member = member;
		this.question = question;
		this.descs = descs;
		this.dates = dates;
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

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


	public String getDescs() {
		return descs;
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

}
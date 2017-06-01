package com.red.beans;

import java.sql.Timestamp;


/**
 * Question entity. @author MyEclipse Persistence Tools
 */

public class Question implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3293948386507801235L;
	private Integer id;
	private QuestionType questionType;
	private Member member;
	private String title;
	private String descs;
	private Timestamp dates;
	private Integer integral;
	private Boolean ispop;
	private Byte sorts;
	

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** minimal constructor */
	public Question(String title, Timestamp dates, Boolean ispop, Byte sorts) {
		this.title = title;
		this.dates = dates;
		this.ispop = ispop;
		this.sorts = sorts;
	}

	/** full constructor */
	public Question(QuestionType questionType, Member member, String title,
			String descs, Timestamp dates, Integer integral, Boolean ispop,
			Byte sorts) {
		this.questionType = questionType;
		this.member = member;
		this.title = title;
		this.descs = descs;
		this.dates = dates;
		this.integral = integral;
		this.ispop = ispop;
		this.sorts = sorts;
	
	}
	// Property accessors

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public Timestamp getDates() {
		return dates;
	}

	public void setDates(Timestamp dates) {
		this.dates = dates;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Boolean getIspop() {
		return ispop;
	}

	public void setIspop(Boolean ispop) {
		this.ispop = ispop;
	}

	public Byte getSorts() {
		return sorts;
	}

	public void setSorts(Byte sorts) {
		this.sorts = sorts;
	}

}
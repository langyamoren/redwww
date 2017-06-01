package com.red.beans;



/**
 * QuestionType entity. @author MyEclipse Persistence Tools
 */

public class QuestionType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 190805284836804594L;
	private Integer id;
	private QuestionType questionType;
	private String name;
	private Byte sorts;
	

	// Constructors

	/** default constructor */
	public QuestionType() {
	}

	/** minimal constructor */
	public QuestionType(String name, Byte sorts) {
		this.name = name;
		this.sorts = sorts;
	}

	/** full constructor */
	public QuestionType(QuestionType questionType, String name, Byte sorts) {
		this.questionType = questionType;
		this.name = name;
		this.sorts = sorts;
		
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public QuestionType getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getSorts() {
		return this.sorts;
	}

	public void setSorts(Byte sorts) {
		this.sorts = sorts;
	}



}
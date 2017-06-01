package com.red.beans;

/**
 * CourseType entity. @author MyEclipse Persistence Tools
 */

public class CourseType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4393645288114296326L;
	private Integer id;
	private String name;
	private Byte sorts;

	// Constructors

	/** default constructor */
	public CourseType() {
	}

	/** minimal constructor */
	public CourseType(String name, Byte sorts) {
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
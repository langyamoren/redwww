package com.red.beans;

/**
 * DownType entity. @author MyEclipse Persistence Tools
 */

public class DownType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 532389196936036097L;
	private Integer id;
	private String name;
	private Byte sorts;


	// Constructors

	/** default constructor */
	public DownType() {
	}

	/** minimal constructor */
	public DownType(String name, Byte sorts) {
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
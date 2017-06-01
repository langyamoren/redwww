package com.red.beans;


/**
 * ArticleType entity. @author MyEclipse Persistence Tools
 */

public class ArticleType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6811006255149953763L;
	private Integer id;
	private String name;
	private Byte sorts;


	// Constructors

	/** default constructor */
	public ArticleType() {
	}

	/** minimal constructor */
	public ArticleType(String name, Byte sorts) {
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
		return sorts;
	}

	public void setSorts(Byte sorts) {
		this.sorts = sorts;
	}

	

}
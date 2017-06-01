package com.red.beans;

/**
 * Focus entity. @author MyEclipse Persistence Tools
 */

public class Focus implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6762430542741407744L;
	private Integer id;
	private String title;
	private String picture;
	private Byte sorts;
	private String url;

	// Constructors

	/** default constructor */
	public Focus() {
	}

	/** minimal constructor */
	public Focus(String title, String url) {
		this.title = title;
		this.url = url;
	}

	/** full constructor */
	public Focus(String title, String picture, Byte sorts, String url) {
		this.title = title;
		this.picture = picture;
		this.sorts = sorts;
		this.url = url;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Byte getSorts() {
		return this.sorts;
	}

	public void setSorts(Byte sorts) {
		this.sorts = sorts;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
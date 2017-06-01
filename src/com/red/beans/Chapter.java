package com.red.beans;

import java.sql.Timestamp;

/**
 * Chapter entity. @author MyEclipse Persistence Tools
 */

public class Chapter implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 626809124570855430L;
	private Integer id;
	private Course course;
	private String title;
	private String content;
	private String contentPic;
	private Boolean isFree;
	private String vodPath;
	private String keywords;
	private Timestamp dates;
	private String abstracts;

	// Constructors

	/** default constructor */
	public Chapter() {
	}

	/** minimal constructor */
	public Chapter(String title, String content, Boolean isFree, Timestamp dates) {
		this.title = title;
		this.content = content;
		this.isFree = isFree;
		this.dates = dates;
	}

	/** full constructor */
	public Chapter(Course course, String title, String content,
			String contentPic, Boolean isFree, String vodPath, String keywords,
			Timestamp dates, String abstracts) {
		this.course = course;
		this.title = title;
		this.content = content;
		this.contentPic = contentPic;
		this.isFree = isFree;
		this.vodPath = vodPath;
		this.keywords = keywords;
		this.dates = dates;
		this.abstracts = abstracts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentPic() {
		return this.contentPic;
	}

	public void setContentPic(String contentPic) {
		this.contentPic = contentPic;
	}

	public Boolean getIsFree() {
		return this.isFree;
	}

	public void setIsFree(Boolean isFree) {
		this.isFree = isFree;
	}

	public String getVodPath() {
		return this.vodPath;
	}

	public void setVodPath(String vodPath) {
		this.vodPath = vodPath;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Timestamp getDates() {
		return this.dates;
	}

	public void setDates(Timestamp dates) {
		this.dates = dates;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	

}
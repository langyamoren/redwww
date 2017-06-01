package com.red.beans;

import java.sql.Timestamp;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 16493774275438438L;
	private Integer id;
	private CourseType courseType;
	private String title;
	private Boolean isrecom;
	private Byte sorts;
	private String picture;
	private Boolean islock;
	private Integer counts;
	private Timestamp dates;
	private String descs;
	private String keyword;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String title, Byte sorts, Timestamp dates, String descs) {
		this.title = title;
		this.sorts = sorts;
		this.dates = dates;
		this.descs = descs;
	}

	/** full constructor */
	public Course(CourseType courseType, String title, Boolean isrecom,
			Byte sorts, String picture, Boolean islock, Integer counts,
			Timestamp dates, String descs,String keyword) {
		this.courseType = courseType;
		this.title = title;
		this.isrecom = isrecom;
		this.sorts = sorts;
		this.picture = picture;
		this.islock = islock;
		this.counts = counts;
		this.dates = dates;
		this.descs = descs;
		this.keyword=keyword;
		
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CourseType getCourseType() {
		return this.courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsrecom() {
		return this.isrecom;
	}

	public void setIsrecom(Boolean isrecom) {
		this.isrecom = isrecom;
	}

	public Byte getSorts() {
		return this.sorts;
	}

	public void setSorts(Byte sorts) {
		this.sorts = sorts;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Boolean getIslock() {
		return this.islock;
	}

	public void setIslock(Boolean islock) {
		this.islock = islock;
	}

	public Integer getCounts() {
		return this.counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Timestamp getDates() {
		return this.dates;
	}

	public void setDates(Timestamp dates) {
		this.dates = dates;
	}

	public String getDescs() {
		return this.descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}



}
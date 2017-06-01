package com.red.beans;

import java.sql.Timestamp;

/**
 * Download entity. @author MyEclipse Persistence Tools
 */

public class Download implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 2222566016476957984L;
	private Integer id;
	private DownType downType;
	private Member member;
	private String title;
	private String descs;
	private String sizes;
	private Timestamp dates;
	private Integer counts;
	private String platform;
	private String softFile;
	private String keyword;
	private String oldName;
	private String language;
	private Boolean ispop;
	private String contentType;
	private Boolean isfree;
	private String picture;
	private Boolean ispass;

	// Constructors

	/** default constructor */
	public Download() {
	}

	/** minimal constructor */
	public Download(String title, Timestamp dates, Boolean ispop,
			Boolean isfree, Boolean ispass) {
		this.title = title;
		this.dates = dates;
		this.ispop = ispop;
		this.isfree = isfree;
		this.ispass = ispass;
	}

	/** full constructor */
	public Download(DownType downType, Member member, String title,
			String descs, String sizes, Timestamp dates, Integer counts,
			String platform, String softFile, String keyword, String oldName,
			String language, Boolean ispop, String contentType, Boolean isfree,
			String picture, Boolean ispass) {
		this.downType = downType;
		this.member = member;
		this.title = title;
		this.descs = descs;
		this.sizes = sizes;
		this.dates = dates;
		this.counts = counts;
		this.platform = platform;
		this.softFile = softFile;
		this.keyword = keyword;
		this.oldName = oldName;
		this.language = language;
		this.ispop = ispop;
		this.contentType = contentType;
		this.isfree = isfree;
		this.picture = picture;
		this.ispass = ispass;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DownType getDownType() {
		return this.downType;
	}

	public void setDownType(DownType downType) {
		this.downType = downType;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescs() {
		return this.descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public String getSizes() {
		return this.sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public Timestamp getDates() {
		return this.dates;
	}

	public void setDates(Timestamp dates) {
		this.dates = dates;
	}

	public Integer getCounts() {
		return this.counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getSoftFile() {
		return this.softFile;
	}

	public void setSoftFile(String softFile) {
		this.softFile = softFile;
	}

	

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOldName() {
		return this.oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getIspop() {
		return this.ispop;
	}

	public void setIspop(Boolean ispop) {
		this.ispop = ispop;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Boolean getIsfree() {
		return isfree;
	}
	public void setIsfree(Boolean isfree) {
		this.isfree = isfree;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Boolean getIspass() {
		return this.ispass;
	}

	public void setIspass(Boolean ispass) {
		this.ispass = ispass;
	}

}
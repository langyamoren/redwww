package com.red.beans;

import java.sql.Timestamp;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {

	private static final long serialVersionUID = -426303572778484043L;
	private Integer id;
	private ArticleType articleType;
	private Member member; //谁发布的文章
	private String title;
	private String content;
	private String abstracts;
	private String keyword;
	private String fromdesc;
	private String fromaddr;
	private String author;
	private String contentPic;
	private Timestamp dates;
	private Boolean isred;
	private Byte sorts;
	private Boolean ispass;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(String title, String content, String keyword,
			Timestamp dates, Boolean isred, byte sorts, Boolean ispass) {
		this.title = title;
		this.content = content;
		this.keyword = keyword;
		this.dates = dates;
		this.isred = isred;
		this.sorts = sorts;
		this.ispass = ispass;
	}

	/** full constructor */
	public Article(ArticleType articleType, Member member, String title,
			String content, String abstracts, String keyword, String fromdesc,
			String fromaddr, String author, String contentPic,
			Timestamp dates, Boolean isred, byte sorts, Boolean ispass) {
		this.articleType = articleType;
		this.member = member;
		this.title = title;
		this.content = content;
		this.abstracts = abstracts;
		this.keyword = keyword;
		this.fromdesc = fromdesc;
		this.fromaddr = fromaddr;
		this.author = author;
		this.contentPic = contentPic;
		this.dates = dates;
		this.isred = isred;
		this.sorts = sorts;
		this.ispass = ispass;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArticleType getArticleType() {
		return this.articleType;
	}

	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getFromdesc() {
		return this.fromdesc;
	}

	public void setFromdesc(String fromdesc) {
		this.fromdesc = fromdesc;
	}

	public String getFromaddr() {
		return this.fromaddr;
	}

	public void setFromaddr(String fromaddr) {
		this.fromaddr = fromaddr;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContentPic() {
		return this.contentPic;
	}

	public void setContentPic(String contentPic) {
		this.contentPic = contentPic;
	}



	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public Timestamp getDates() {
		return dates;
	}

	public void setDates(Timestamp dates) {
		this.dates = dates;
	}

	public Boolean getIsred() {
		return this.isred;
	}

	public void setIsred(Boolean isred) {
		this.isred = isred;
	}

	public byte getSorts() {
		return this.sorts;
	}

	public void setSorts(byte sorts) {
		this.sorts = sorts;
	}

	public Boolean getIspass() {
		return this.ispass;
	}

	public void setIspass(Boolean ispass) {
		this.ispass = ispass;
	}

}
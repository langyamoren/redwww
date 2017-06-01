package com.red.beans;

/**
 * Memberlevel entity. @author MyEclipse Persistence Tools
 */

public class Memberlevel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2382338472085348994L;
	private Integer id;
	private String levelName;
	private Integer integral;
	private Integer percent;
	// Constructors

	/** default constructor */
	public Memberlevel() {
	}

	/** minimal constructor */
	public Memberlevel(String levelName, Integer percent) {
		this.levelName = levelName;
		this.percent = percent;
	}

	/** full constructor */
	public Memberlevel(String levelName, Integer integral, Integer percent) {
		this.levelName = levelName;
		this.integral = integral;
		this.percent = percent;
		
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getPercent() {
		return this.percent;
	}

	public void setPercent(Integer percent) {
		this.percent = percent;
	}

	

}
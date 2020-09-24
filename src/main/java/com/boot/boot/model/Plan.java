package com.boot.boot.model;



/**
 * boot 
 * Plan  计划表
 * @author 10247
 * @version    
 * 2019年2月23日 下午7:52:24  
 */
public class Plan {

	private String id;
	
	private String planTime;
	
	private String userId;
	
	private String planName;
	
	public Plan() {
		// TODO Auto-generated constructor stub
	}

	public Plan(String id, String planTime, String userId, String planName) {
		super();
		this.id = id;
		this.planTime = planTime;
		this.userId = userId;
		this.planName = planName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	
}

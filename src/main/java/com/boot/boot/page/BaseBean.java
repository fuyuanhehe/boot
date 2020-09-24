package com.boot.boot.page;

import java.util.Date;

/**
   功能说明：     
 @version  1.0.0
 @author  xgYin
 @see  com.studio.framework.beans.BaseBean.java
 @date  2016年12月3日
 */

public abstract class BaseBean {
	//已经删除
	public static final boolean ISDELETE = true;
	// 未删除
	public static final boolean NOTDELETE = false;
	//主键ID
	protected String id;
	//版本号
	private Integer version;
	//记录是否逻辑删除 。true 已删除，false 未删除
	private Boolean isDeleted = false;
	//新增时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//删除时间
	private Date deleteTime;
	//创建人
	private String createBy;
	//创建人名称
	private String createByNm;
	//创建人部门编码
	private String createDepCd;
	//创建人机构名称
	private String createDepNm;
	//修改人
	private String updateBy;
	//修改人名称
	private String updateByNm;
	//修改人部门编码
	private String updateDepCd;
	//修改人部门名称
	private String updateDepNm;



public BaseBean() {
}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the isDeleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the deleteTime
	 */
	public Date getDeleteTime() {
		return deleteTime;
	}

	/**
	 * @param deleteTime the deleteTime to set
	 */
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	/**
	 * @return the createBy
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}


	/**
	 * @return the updateBy
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}


	/**
	 * @return the createByNm
	 */
	public String getCreateByNm() {
		return createByNm;
	}

	/**
	 * @param createByNm the createByNm to set
	 */
	public void setCreateByNm(String createByNm) {
		this.createByNm = createByNm;
	}

	/**
	 * @return the updateByNm
	 */
	public String getUpdateByNm() {
		return updateByNm;
	}

	/**
	 * @param updateByNm the updateByNm to set
	 */
	public void setUpdateByNm(String updateByNm) {
		this.updateByNm = updateByNm;
	}


	public String getCreateDepCd() {
		return createDepCd;
	}


	public void setCreateDepCd(String createDepCd) {
		this.createDepCd = createDepCd;
	}


	public String getCreateDepNm() {
		return createDepNm;
	}


	public void setCreateDepNm(String createDepNm) {
		this.createDepNm = createDepNm;
	}


	public String getUpdateDepCd() {
		return updateDepCd;
	}


	public void setUpdateDepCd(String updateDepCd) {
		this.updateDepCd = updateDepCd;
	}


	public String getUpdateDepNm() {
		return updateDepNm;
	}


	public void setUpdateDepNm(String updateDepNm) {
		this.updateDepNm = updateDepNm;
	}
}

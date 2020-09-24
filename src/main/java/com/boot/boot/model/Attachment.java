package com.boot.boot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;


/**
   功能说明：     附件Bean
 @version  1.0.0
 @author  lm
 @see  com.studio.framework.beans.attachment.Attachment.java
 @date  2016年12月14日
 */

public class Attachment implements Serializable {
	private static final long serialVersionUID = 2725950871498794398L;
	
	/**
	 * 普通文件
	 */
	public static final Integer ATTACH_TYPE_FILE = 0;
	
	/**
	 * 图片类型
	 */
	public static final Integer ATTACH_TYPE_IMG = 1;
	
	/**
	 * 视频问
	 */
	public static final Integer ATTACH_TYPE_VIDEO = 1;

	//附件ID
	private String id;
	//资料类别
	//附件类型 0 文件 1图片 
	private Integer attachmentType = 0;
	//资料类别
	private String attachmentTypeStr;
	//附件名称
	private String attachmentNm;
	//附件路径
	private String attachmentPath;
	//附件分组
	private String attachmentGroup;
	//上传时间
	private Date uploadTime;
	//删除时间
	private Date deleteTime;
	//上传编码
	private String createBy;
	//上传者名称
	private String createNm;
	
	private byte[] fileBytes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(Integer attachmentType) {
		this.attachmentType = attachmentType;
	}

	public String getAttachmentTypeStr() {
		return attachmentTypeStr;
	}

	public void setAttachmentTypeStr(String attachmentTypeStr) {
		this.attachmentTypeStr = attachmentTypeStr;
	}

	public String getAttachmentNm() {
		return attachmentNm;
	}

	public void setAttachmentNm(String attachmentNm) {
		this.attachmentNm = attachmentNm;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public String getAttachmentGroup() {
		return attachmentGroup;
	}

	public void setAttachmentGroup(String attachmentGroup) {
		this.attachmentGroup = attachmentGroup;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateNm() {
		return createNm;
	}

	public void setCreateNm(String createNm) {
		this.createNm = createNm;
	}

	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}

	@Override
	public String toString() {
		return "Attachment [id=" + id + ", attachmentType=" + attachmentType + ", attachmentTypeStr="
				+ attachmentTypeStr + ", attachmentNm=" + attachmentNm + ", attachmentPath=" + attachmentPath
				+ ", attachmentGroup=" + attachmentGroup + ", uploadTime=" + uploadTime + ", deleteTime=" + deleteTime
				+ ", createBy=" + createBy + ", createNm=" + createNm + ", fileBytes=" + Arrays.toString(fileBytes)
				+ "]";
	}
	public Attachment() {
	}

}
	
package com.boot.boot.service;


import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.boot.boot.model.Attachment;
import com.boot.boot.page.Page;
import com.boot.boot.page.Pageable;



public interface FastDfsService {
	
	/**
	 * 根据条件查询附件分页
	 * @param page
	 * @param attachment
	 * @return
	 */
	public Page<Attachment> getAttachments(Pageable page);
	
	
	/**
	 * 根据附件id获取附件
	 * @param busId
	 * @return
	 */
	public Attachment getAttachment(String attachmentId);
	
	
    /**
     * 上传文件
     * @param file 文件对象
     * @param fileType 文件类型  0 文件  1图片 2视频
     * @return 文件访问地址
     * @throws IOException
     */
    public Attachment uploadFile(MultipartFile file,Integer fileType) throws Exception;
    
	/**
	 * 下文件
	 * @param attachmentId 
	 * @param callback
	 */
    public Attachment downloadFile(String attachmentId);
    /**
     * 删除文件
     * @param fileUrl 文件访问地址
     * @return
     */
    public void deleteFile(String attachmentId) ;
}

package com.boot.boot.controller;

import java.io.Serializable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.boot.boot.model.Attachment;
import com.boot.boot.page.Page;
import com.boot.boot.page.PageRequest;
import com.boot.boot.service.FastDfsService;
import com.boot.boot.util.ResponseMsg;


/**
功能说明：     附件信息
@version  1.0.0
@author  xgYin
@date  2016年12月13日
*/
@RestController
@RequestMapping("/attachment")
public class AttachmentController implements Serializable {
	private static final long serialVersionUID = 213026144265132682L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FastDfsService attachmentService;
	
	/**
	 * 根据业务ID获取附件信息
	 * 
	 * @param pageRequest
	 *            分页请求接口
	 * @param post
	 *            查询条件
	 * @return JSON
	 * @throws AppException
	 */
	@RequestMapping(value="/getPages",method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseMsg<List<Attachment>> getAttachments(PageRequest page) throws Exception {
		ResponseMsg<List<Attachment>>  resp = new ResponseMsg<List<Attachment>>();
		try {
			Page<Attachment> attas =  attachmentService.getAttachments(page);
			resp.success("获取附件分页成功");
			resp.setData(attas.getRecords());
			resp.setTotal(attas.getTotalRows().intValue());
		}catch (Exception e) {
			resp.fail("获取附件分页失败");
			logger.error("获取附件分页失败",e);
		}
		return resp;
	}
	
	
	@RequestMapping(value="/getSingle",method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseMsg<Attachment> getAttachment(String attachmentId) throws Exception {
		ResponseMsg<Attachment> resp = new ResponseMsg<Attachment>();
		try {
			Attachment atta = attachmentService.getAttachment(attachmentId);
			resp.setData(atta);
			resp.success("获取附件成功");
		}catch (Exception e) {
			resp.fail("获取附件失败");
			logger.error("获取附件失败",e);
		}
		return resp;
	}
	
	/**
	 * 根据ID删除附件信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/remove",method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseMsg<String> deleteAttachment(String attachmentId) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			attachmentService.deleteFile(attachmentId);
			resp.success("删除附件失败");
			resp.setData(attachmentId);
		}catch (Exception e) {
			logger.error("删除附件失败", e);
			resp.fail("删除附件失败");
		}
		return resp;
	}
	
	
	/**
	 * 上传附件
	 * 
	 * @param pageRequest
	 *            分页请求接口
	 * @param post
	 *            查询条件
	 * @return JSON
	 */
	@RequestMapping(value="/upload",method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseMsg<Attachment> uploadAttachment(MultipartFile uploadFile, Integer fileType) {
		ResponseMsg<Attachment> resp = new ResponseMsg<Attachment>();
		try {
			Attachment att = attachmentService.uploadFile(uploadFile,fileType);
			resp.success("上传附件成功");
			resp.setData(att);
		} catch (Exception e) {
			logger.error("创建文件失败:"+uploadFile.getOriginalFilename(),e);
			resp.fail("上传附件失败");
		}
		return resp;
	}
	
	/**
	 * 附件下载
	 * @param attachmentId
	 * @return
	 */
	@RequestMapping(value="/download",method= {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity<byte[]> downloadAttachment(String attachmentId){
		HttpHeaders headers = new HttpHeaders();
		Attachment atta = attachmentService.downloadFile(attachmentId);
		headers.setContentDispositionFormData("attachment",atta.getAttachmentNm());
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(atta.getFileBytes(),headers,HttpStatus.OK);
	}		
}

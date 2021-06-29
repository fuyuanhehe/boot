/*
package com.boot.boot.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.boot.boot.mapper.AttachmentMapper;
import com.boot.boot.model.Attachment;
import com.boot.boot.page.Page;
import com.boot.boot.page.PageImpl;
import com.boot.boot.page.Pageable;
import com.boot.boot.service.FastDfsService;
import com.boot.boot.util.RandomHelper;
import com.github.tobato.fastdfs.domain.MataData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

@Service
public class FastDfsServiceImpl implements FastDfsService {

	@Autowired
	private AttachmentMapper attachmentMapper;

	@Autowired
	private FastFileStorageClient storageClient;

	@Override
	@Transactional
	public Page<Attachment> getAttachments(Pageable page) {
		Page<Attachment> pager = new PageImpl<Attachment>(page);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", page.getRows());
		params.put("startRecord", (page.getPage() - 1) * page.getRows());
		long totolRols = attachmentMapper.count(params);
		List<Attachment> records = attachmentMapper.findAttachmentList(params);
		pager.setTotalRows(totolRols);
		pager.setRecords(records);
		return pager;
	}

	@Override
	@Transactional
	public Attachment getAttachment(String attachmentId) {
		return attachmentMapper.findAttachmentById(attachmentId);
	}

*
	 * 上传文件
	 * 
	 * @param file
	 *            文件对象
	 * @return 文件访问地址
	 * @throws IOException


	@Transactional
	public Attachment uploadFile(MultipartFile file,Integer fileType) throws IOException {
		// Metadata
		Set<MataData> metaDataSet = new HashSet<MataData>();
		metaDataSet.add(new MataData("Author", "cqytjg"));
		SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd");
		String now = simpleDateFormat.format(new Date());
		metaDataSet.add(new MataData("CreateDate", now));
		Attachment atta = new Attachment();
		StorePath storePath = null;
		if(fileType == null){
			fileType = 0;
		}
		if(Attachment.ATTACH_TYPE_IMG.intValue() == fileType){
			atta.setAttachmentType(Attachment.ATTACH_TYPE_IMG);
			storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(),
					FilenameUtils.getExtension(file.getOriginalFilename()), metaDataSet);  //缩略图生成
		}else if(Attachment.ATTACH_TYPE_VIDEO.intValue() == fileType){
			atta.setAttachmentType(Attachment.ATTACH_TYPE_VIDEO);
			storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(),
					FilenameUtils.getExtension(file.getOriginalFilename()), metaDataSet);
		}else{
			atta.setAttachmentType(Attachment.ATTACH_TYPE_FILE);
			storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(),
					FilenameUtils.getExtension(file.getOriginalFilename()), metaDataSet);
		}
		atta.setId(RandomHelper.uuid());
		atta.setAttachmentNm(file.getOriginalFilename());
		atta.setAttachmentPath(storePath.getPath());
		atta.setAttachmentGroup(storePath.getGroup());
		atta.setUploadTime(new Date());
		attachmentMapper.uploadAttachment(atta);
		return atta;
	}
	
*
	 * 下文件
	 * 
	 * @param attachmentId
	 * @param callback


	@Transactional
	public Attachment downloadFile(String attachmentId) {
		Attachment atta = attachmentMapper.findAttachmentById(attachmentId);
		DownloadByteArray callback = new DownloadByteArray();
		atta.setFileBytes(storageClient.downloadFile(atta.getAttachmentGroup(), atta.getAttachmentPath(),callback));
		return atta;
	}

*
	 * 删除文件
	 * 
	 * @param fileUrl
	 *            文件访问地址
	 * @return


	@Transactional
	public void deleteFile(String attachmentId) {
		Attachment atta = attachmentMapper.findAttachmentById(attachmentId);
		StorePath storePath = StorePath.praseFromUrl(atta.getAttachmentPath());
		storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
		attachmentMapper.removeAttachment(attachmentId);
	}
}
*/

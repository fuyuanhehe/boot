package com.boot.boot.controller;

import com.boot.boot.mapper.UserMapper;
import com.boot.boot.model.User;
import com.boot.boot.util.FileUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fuyan
 * @version
 * 2019年2月23日 下午6:41:08
 *
 */
@RequestMapping(value="/upload")
@RestController
public class UploadEx {

	@Autowired
	private UserMapper UserMapper;


	//创建Excel
	@PostMapping(value="/createExcel")
	//@Transactional
	public  void createExcel(HttpServletResponse response,@RequestParam(value="params") Map<String, Object> params) {
		try {
			//创建HSSFWorkbook对象(excel的文档对象)
			HSSFWorkbook wb = new HSSFWorkbook();
			//建立新的sheet对象（excel的表单）
			HSSFSheet sheet=wb.createSheet("成绩表");
			//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
			HSSFRow row1=sheet.createRow(0);
			//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
			HSSFCell cell=row1.createCell(0);
			//设置单元格内容
			cell.setCellValue("用户表");
			//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
			sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
			//在sheet里创建第二行
			HSSFRow row2=sheet.createRow(1);
			//创建单元格并设置单元格内容
			row2.createCell(0).setCellValue("id");
			row2.createCell(1).setCellValue("name");
			row2.createCell(2).setCellValue("Department");
			//在sheet里创建第三行



			//	List<Map<String, Object>> result = UserMapper.findAll(params);
             // 假数据演示
			List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("id", "1");
			m.put("name", "老王");
			m.put("Department", "开发部");

			Map<String, Object> m2 = new HashMap<String, Object>();
			m2.put("id", "2");
			m2.put("name", "老张");
			m2.put("Department", "测试部");

			result.add(m);
			result.add(m2);

			HSSFRow row3 = null;

			for (int i = 0; i < result.size(); i++) {
				row3 = sheet.createRow(2+i) ;

				row3.createCell(0).setCellValue(result.get(i).get("id").toString());
				row3.createCell(1).setCellValue(result.get(i).get("name").toString());
				row3.createCell(2).setCellValue(result.get(i).get("Department").toString());

			}

			//输出Excel文件
			OutputStream output=response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename=user.xls");
			response.setContentType("application/msexcel");
			wb.write(output);
			output.close();
		} catch (Exception e) {

		}
	}

	public static void readExcel()  {
		try {

			String fileName = "src/user.xlsx";
			InputStream is = new FileInputStream(new File(fileName));
			Workbook hssfWorkbook = null;
			if (fileName.endsWith("xlsx")){
				hssfWorkbook = new XSSFWorkbook(is);//Excel 2007
			}else if (fileName.endsWith("xls")){
				hssfWorkbook = new HSSFWorkbook(is);//Excel 2003

			}
			// HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
			// XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
			User student = null;
			List<User> list = new ArrayList<User>();
			// 循环工作表Sheet
			for (int numSheet = 0; numSheet <hssfWorkbook.getNumberOfSheets(); numSheet++) {
				//HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
				Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
				if (hssfSheet == null) {
					continue;
				}
				// 循环行Row
				for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
					//HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					Row hssfRow = hssfSheet.getRow(rowNum);
					if (hssfRow != null) {

						student = new User();
						//HSSFCell name = hssfRow.getCell(0);
						//HSSFCell pwd = hssfRow.getCell(1);
						Cell id = hssfRow.getCell(0);
						Cell name = hssfRow.getCell(1);
						Cell department = hssfRow.getCell(2);
						//这里是自己的逻辑
				//		student.setId(id.toString());
				//		student.setName(name.toString());
				//		student.setDepartment(department.toString());

						/*
						 * System.out.println(student.getId()); System.out.println(student.getName());
						 * System.out.println(student.getDepartment());
						 */
						list.add(student);
					}
				}
			}
		} catch (Exception e) {
		}

	}


	@PostMapping(value="/download")
	@Transactional
	public void download(HttpServletResponse response,@RequestParam(value="filePath",required=true) String filePath) {

		OutputStream out = null;
		FileInputStream in = null;
		//路径
		//String filePath =  "" ;  //this.queueService.getCsvFilePathById(id);//所要下载的文件路径，从数据库中查询得到，当然也可以直接写文件路径，如：C:\\Users\\Administrator\\Desktop\\csv\\号码_utf8_100.csv
		try {
			File file = new File(filePath);
			String fileName = filePath.substring(filePath.lastIndexOf(File.separator)+1);//得到文件名
			fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");//把文件名按UTF-8取出并按ISO8859-1编码，保证弹出窗口中的文件名中文不乱码，中文不要太多，最多支持17个中文，因为header有150个字节限制。
			response.setContentType("application/octet-stream");//告诉浏览器输出内容为流
			response.addHeader("Content-Disposition", "attachment;filename="+fileName);//Content-Disposition中指定的类型是文件的扩展名，并且弹出的下载对话框中的文件类型图片是按照文件的扩展名显示的，点保存后，文件以filename的值命名，保存类型以Content中设置的为准。注意：在设置Content-Disposition头字段之前，一定要设置Content-Type头字段。
			String len = String.valueOf(file.length());
			response.setHeader("Content-Length", len);//设置内容长度
			 out = response.getOutputStream();
			 in = new FileInputStream(file);
			byte[] b = new byte[1024];
			int n;
			while((n = in.read(b)) != -1){
				out.write(b, 0, n);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//处理文件上传
	@PostMapping(value="/upload")
	@Transactional
	public @ResponseBody String uploadImg(@RequestParam(value="file") MultipartFile file,
			HttpServletRequest request,@RequestParam(value="filePath",defaultValue="src/main/webapp/upload/",required=false)String filePath) {

	//	String contentType = file.getContentType();   图片文件类型
		String fileName = file.getOriginalFilename();  //图片名字

		//文件存放路径
	//	String filePath = "src/main/webapp/upload/";

		//调用文件处理类FileUtil，处理文件，将文件写入指定位置
		try {
			FileUtil.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// 返回图片的存放路径
		return filePath;
	}


}

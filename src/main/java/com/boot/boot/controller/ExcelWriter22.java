package com.boot.boot.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.boot.boot.model.DemoData;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/*@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
@RestController
@RequestMapping(value = "/test2")*/
@Controller
public class ExcelWriter22 {


    @GetMapping("/export")
    public static void export(HttpServletResponse response) throws IOException {
        // 生成数据
        List<DemoData> respCustomerDailyImports = Lists.newArrayList();
        for (int i = 0; i < 50; i++) {
            DemoData respCustomerDailyImport = new DemoData();
            respCustomerDailyImport.setId(i);
            respCustomerDailyImport.setName("a" + i);
            respCustomerDailyImports.add(respCustomerDailyImport);
        }

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("导出", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");


        EasyExcel.write(response.getOutputStream(), DemoData.class)
                .sheet("sheet0")
                // 设置字段宽度为自动调整，不太精确
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .doWrite(respCustomerDailyImports);

    }

    public static void main(String[] args) throws Exception {

    }

    //创建方法返回list集合
    public static List<DemoData> getData() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setId(i);
            data.setName("lucy" + i);
            list.add(data);
        }
        return list;

    }

    @RequestMapping("index2")
    public String test() {
        return "index2";
    }

    /*   @RequestMapping(value = "/getPage")
       public PageInfo<User> test(User user,int pageSize,int pageNum) {
           PageInfo<User> result = userService.findPage(pageSize,pageNum);
           return result;
           //  au2  au2 = applicationContext.getBean(au2.class);
           //  au2.add();

       }*/
//http://localhost:8888/test2/getPage?pageNum=1&pageSize=2&ok=xx&salt=plplpl

    @RequestMapping("/exportExcel22")
    public void export2(HttpServletResponse response) throws IOException {
        List<DemoData> list = getData();
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = "测试exportExcel";
        Sheet sheet = new Sheet(1, 0, DemoData.class);
        //设置自适应宽度
        sheet.setAutoWidth(Boolean.TRUE);
        // 第一个 sheet 名称
        sheet.setSheetName("第一个sheet");
        writer.write(list, sheet);
        //通知浏览器以附件的形式下载处理，设置返回头要注意文件名有中文
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".xlsx");
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        out.flush();
        writer.finish();
    }

    @PostMapping("/import")
    public void importCustomerDaily(@RequestParam MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        List<DemoData> reqCustomerDailyImports = EasyExcel.read(inputStream)
                .head(DemoData.class)
                // 设置sheet,默认读取第一个
                .sheet()
                // 设置标题所在行数    学生编号  学生姓名 所在行数
                .headRowNumber(2)
                .doReadSync();

        reqCustomerDailyImports.forEach(
                System.out::println

        );


    }




 /*   @RequestMapping(value = "/t")
    public String t() {
        String s = null;
        try {
            int a = 1 / 0;
        } catch (RuntimeException e) {
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
        }
        return s;
    }*/

   /* @Scheduled(fixedRate = 1000)
    public void test3() {
        System.out.println(111);
    }*/


}
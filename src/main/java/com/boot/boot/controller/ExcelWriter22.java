package com.boot.boot.controller;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.boot.boot.model.DemoData;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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


        EasyExcelFactory.write(response.getOutputStream(), DemoData.class)
                .sheet("sheet0")
                // 设置字段宽度为自动调整，不太精确
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .doWrite(respCustomerDailyImports);

    }


    //创建方法返回list集合
    private static List<DemoData> getData() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setId(i);
            data.setName("xxxxxx" + i);
            list.add(data);
        }
        return list;

    }


    @PostMapping("/import")
    public void importCustomerDaily(@RequestParam MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        List<DemoData> reqCustomerDailyImports = EasyExcelFactory.read(inputStream)
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
    // 写法1
  /*  String fileName = "F:\\11.xlsx";
    // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
    // 如果这里想使用03 则 传入excelType参数即可
    EasyExcel.write(fileName, DemoData.class).sheet("写入方法一").doWrite(data());
*/
    public static void main(String[] args) throws Exception {
        // 写法2，方法二需要手动关闭流
        String fileName = "src/main/webapp/w22w.xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcelFactory.write(fileName, DemoData.class).build();
        WriteSheet writeSheet = EasyExcelFactory.writerSheet("写入方法二").build();
        excelWriter.write(getData(), writeSheet);
        /// 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
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

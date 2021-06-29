package com.boot.boot.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class DemoData  extends BaseRowModel {
    //设置excel表头名称

   // @ExcelProperty({"主标题", "字符串标题"})

    @ExcelProperty(value = "学生编号",index = 0)
    private Integer id;
    @ExcelProperty(value = "学生姓名",index = 1)
    private String name;
}
package com.boot.boot.controller;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.boot.boot.model.DemoData;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public  class  ExcelListener extends AnalysisEventListener<DemoData> {
    //一行一行读取excel内容
    @Override
    public  void  invoke(DemoData data, AnalysisContext analysisContext) {
        System.out.println("****"+data);


        if (StringUtils.isEmpty(data.getName())) {
            throw new RuntimeException(String.format("第%s行学生姓名为空，请核实", analysisContext.readRowHolder().getRowIndex() + 1));
        }
        if (StringUtils.isEmpty(data.getName())) {
            throw new RuntimeException(String.format("第%s行学生姓名已重复，请核实", analysisContext.readRowHolder().getRowIndex() + 1));
        } else {
            System.out.println(  data);

        }


    }
    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {

           headMap.entrySet().forEach(m->{

               System.out.println(m.getKey());
               System.out.println(m.getValue());
           });

       // System.out.println("表头："+headMap);
    }
    //读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) { }


}
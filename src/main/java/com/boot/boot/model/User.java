package com.boot.boot.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
//@TableName("t_user")
public class User implements Serializable ,AutoCloseable{

    @ExcelProperty(index = 0, value = "id")
    public int id;
    @ExcelProperty(index = 1, value = "username")
    private String username;
    @ExcelProperty(index = 2, value = "password")
    private String password;
    @ExcelProperty(index = 3, value = "salt还好")
    private String salt;

    @NotNull(message = "createDate is not null")
    private Date createDate;
    private LocalDateTime updateDate;


    // 出参     date  转 字符串
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    // 时间戳
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date date1;


    // 转 json 时 帮你转成字符串  JSON.toJSONString(date7)
    @JSONField(format = "yyyy-MM-dd")
    private Date date7;

    @Value("${www.fuyuan}")
    private String value;


    @PostConstruct
    public void test33() {
        for (int i = 0; i < 3; i++) {
            System.out.println("------------------22222");
            System.out.println(value);
        }

    }

    @PreDestroy
    public void test3344() {
        for (int i = 0; i < 3; i++) {
            System.out.println("------------------3333");
        }
    }


    @Override
    public void close() throws Exception {
        System.out.println("------------------close");
    }
}

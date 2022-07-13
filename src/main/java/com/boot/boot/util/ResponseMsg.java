package com.boot.boot.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseMsg<T> implements Serializable {

    public static final Integer STATUS_SUCCESS = 200;
    public static final Integer STATUS_FAIL = 500;
    private Integer code;

    private String msg;

    private T data;

    private Integer total = 0;

    public ResponseMsg<T> ok(T T) {
        return new ResponseMsg<T>(STATUS_SUCCESS, "成功", T, total);
    }


    public ResponseMsg<T> err() {
        return new ResponseMsg<T>(STATUS_FAIL, "失败",null,total);
    }

}

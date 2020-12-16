/*
package com.boot.boot.logger;

import com.boot.boot.page.Page;
import com.boot.boot.page.Pageable;

public interface UserOperLoggerService {
    */
/**
     * 说明：增加UserOperLogger
     * *//*

    void addUserOperLogger(UserOperLogger userOperLogger);

    */
/**
     * 说明：删除一个UserOperLogger
     * *//*

    void delUserOperLogger(String id);
    
    */
/**
     * 添加日志表
     * @return
     *//*

    void addUserOperLoggerTb();

    */
/**
     * 说明：查询所有的参数
     * map keys：【content：内容，operBy：操作者，operTime：操作时间，ipAddr：ip地址，remark：备注，
     * startRecod：开始页码，offset：结束页码】
     * *//*

    Page<UserOperLogger> findAllUserOperLogger(UserOperLogger logger, Pageable page);

    */
/**
     * 说明：查找单个日志
     * *//*

    UserOperLogger findSingleUserOperLog(String id);
}
*/

package com.boot.boot.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.boot.boot.logger.UserOperLogger;


/**
 * 说明：用户日志操作
 * */
public interface UserOperLoggerMapper {
    /**
     * 说明：增加UserOperLogger
     * */
    boolean addUserOperLogger(@Param("logger") UserOperLogger userOperLogger, @Param("curDate") String curDate);

    /**
     * 说明：删除一个UserOperLogger
     * */
    boolean delUserOperLogger(@Param("id") String id, @Param("curDate") String curDate);
    
    /**
     * 添加日志表
     * 当天创建下一天的日志表
     * @return
     */
    boolean addUserOperLoggerTb(@Param("nextDate") String nextDate);

    /**
     * 说明：查询所有的参数
     * map keys：【content：内容，operBy：操作者，operTime：操作时间，ipAddr：ip地址，remark：备注，
     * startRecod：开始页码，offset：结束页码】
     * */
    List<UserOperLogger> findAllUserOperLogger(@Param("params")Map<String, Object> params,  @Param("curDate") String curDate);

    /**
     * 统计条数
     * 说明：查询所有的参数
     * map keys：【operName：操作者，url：访问的URL，startTime：开始时间，endTime：结束时间，success：是否成功】
     * */
    Long findAllUserOperLoggerCount(@Param("params")Map<String, Object> params,  @Param("curDate") String curDate);

    /**
     * 说明：查找单个日志
     * */
    UserOperLogger findSingleUserOperLog( @Param("id")String id,  @Param("curDate") String curDate);
    
}

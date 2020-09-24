package com.boot.boot.logger;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;


public class LoggerWorker {
    // 缓存
    private static final ConcurrentHashMap<Method, LoggerModel> LOGGER_MODEL_CONCURRENT_HASH_MAP = new ConcurrentHashMap<>();

    /**
     * 说明：判断类上面有没有全局的日志记录
     * */
    public static boolean isClassLogger(Class<?> cls) {
    	OperLogging annotation = cls.getAnnotation(OperLogging.class);
        return annotation != null;
    }

    /**
     * 说明：判断方法需不需要日志记录
     * */
    public static boolean isMethodLogger(Method method) {
    	OperLogging annotation = method.getAnnotation(OperLogging.class);
        return annotation != null;
    }

    /**
     * 说明：获得LoggerModel数据
     * */
    public static LoggerModel getLoggerInfo(Method method) {
        LoggerModel model = null;
        model = LOGGER_MODEL_CONCURRENT_HASH_MAP.get(method);
        if (model != null)
            return model;
        // 获得他所在的类
        Class<?> declaringClass = method.getDeclaringClass();
        if (isClassLogger(declaringClass)) {
            model = new LoggerModel();
            // 获得他所在类的注解
            OperLogging classAnnotation = declaringClass.getAnnotation(OperLogging.class);
            // 设置内容
            if (classAnnotation.content() != null && classAnnotation.content().length() != 0)
                model.setContent(classAnnotation.content());
            // 设置备注
            if (classAnnotation.remark() != null && classAnnotation.remark().length() != 0)
                model.setRemark(classAnnotation.remark());
            // 设置操作类型
            model.setOperType(classAnnotation.operType());
        }
        // 如果方法没有注解，那么返回数据（注意他所在的类有没有注解）
        if (!isMethodLogger(method))
            return model;
        // 获得方法上的注解
        OperLogging methodAnnotation = method.getAnnotation(OperLogging.class);
        if (model == null)
            model = new LoggerModel();
        // 设置内容
        if (methodAnnotation.content() != null && methodAnnotation.content().length() != 0) {
            if (model.getContent() != null && model.getContent().length() != 0) {
                model.setContent(model.getContent() + "-"  + methodAnnotation.content());
            } else {
                model.setContent(methodAnnotation.content());
            }
        }
        // 设置备注
        if (methodAnnotation.remark() != null && methodAnnotation.remark().length() != 0) {
            if (model.getRemark() != null && model.getRemark().length() != 0) {
                model.setRemark(model.getRemark() + "-" + methodAnnotation.remark());
            } else {
                model.setRemark(methodAnnotation.remark());
            }
        }
        // 设置操作类型
        model.setOperType(methodAnnotation.operType());
        LOGGER_MODEL_CONCURRENT_HASH_MAP.put(method, model);
        return model;
    }
}

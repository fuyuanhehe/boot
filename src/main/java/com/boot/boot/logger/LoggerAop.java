/*
package com.boot.boot.logger;

import com.boot.boot.util.CCtticDateUtils;
import com.boot.boot.util.CCtticWebUtils;
import com.boot.boot.util.CommonGenerator;
import com.boot.boot.util.JWTUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

*/
/**
 * 说明：记录用户操作日志
 * 
 * @author wl
 * @date 2018年5月24日 09:45:49
 *//*

@Aspect
@Configuration
public class LoggerAop {

	@Autowired
	private UserOperLoggerService userOperLoggerService;
	
	Logger logger = LoggerFactory.getLogger(LoggerAop.class);

	// token key
	public final static String AUTHORIZATION = "Authorization";

	// 网关中必须将用户姓名写入request域，USER_NAME_TOKEN 就是key
	public static final String USER_NAME_TOKEN = "authentication_name";


	@Around("execution(* com.boot.boot.controller.*.*(..))")
	public Object logAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		writeLogger(joinPoint);
		// 执行目标方法,如果这一句不执行，那么目标方法不会执行
		return joinPoint.proceed();
	}

	private void writeLogger(ProceedingJoinPoint joinPoint) {
		try {
			// 获得request
			ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = (sra == null ? null : sra.getRequest());

			// 获得方法对象
			Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
			// 获得用户的基本操作日志

			// 需要保存的UserOperLogger
			UserOperLogger userOperLogger = new UserOperLogger();
			String token = request.getHeader(AUTHORIZATION);
			String zjhm = null;
			if (token == null)
				userOperLogger.setOperBy("游客");
			else {
				// 获得姓名 这一步可以异步操作，优化响应时间
				zjhm = JWTUtil.getUsername(token);
				if (zjhm == null)
					zjhm = "游客";
				userOperLogger.setOperBy("" + zjhm);
			}

			// 设置基本信息
			userOperLogger.setOperType(3);
			userOperLogger.setId(CommonGenerator.distributiveIDGenerator());
			userOperLogger.setIpAddr(CCtticWebUtils.getRemoteHost(request));
			userOperLogger.setOperTime(CCtticDateUtils.presentDay("yyyy-MM-dd HH:mm:ss"));
			userOperLogger.setContent(method.toGenericString());
			
			Object [] params = joinPoint.getArgs();
			if(params != null && params.length > 0){
				userOperLogger.setOperParam(Arrays.toString(params));
			}

			// 获得方法和他所在类它上面的注解信息
			LoggerModel loggerInfo = LoggerWorker.getLoggerInfo(method);//TODO
			if (loggerInfo != null) {
				userOperLogger.setContent(loggerInfo.getContent());
				userOperLogger.setRemark(loggerInfo.getRemark());
				userOperLogger.setOperType(loggerInfo.getOperType());
			}
			// 异步保存用户日志
		//	userOperLoggerService.addUserOperLogger(userOperLogger);
		} catch (Throwable e) {
			logger.error("AOP保存日志异常", e);
		}
	}
}
*/

package log2;/*
package log2;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.hg.xdxswyh.basics.pojo.DO.UserInfo;
import com.hg.xdxswyh.basics.service.IUserInfoService;
import com.hg.xdxswyh.config.security.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hg.xdxswyh.basics.service.ILogService;
import com.hg.xdxswyh.common.utils.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

*/
/**
* @Description: 日志切面
* @CreateDate: 2019/5/2 8:59
* @Version: 1.0.0
*//*

@Aspect
@Component
public class LogAspect {
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private ILogService logService;

    @Autowired
    private IUserInfoService userInfoService;
    */
/**
    * @Description: 申明切入点
    * @Author: 张润东
    * @CreateDate: 2019/5/2 9:02
    * @UpdateUser: 张润东
    * @UpdateDate: 2019/5/2 9:02
    * @UpdateRemark: 修改内容
    * @param:
    * @return:
    * @Version: 1.0.0
    *//*

 //   @Pointcut("execution(public * com.hg.xdxswyh.*.controller.*(..))")

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void pointCut(){

    }
    */
/**
     * 功能描述: log
     * @auther: fuyuan
     * @date: 2019/6/17 0017 17:33
     *//*

    @Around("pointCut()")
    public Object aroundMethod(ProceedingJoinPoint jp){
        Object result = null;
        Log log = new Log();
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            //创建log 对象
            //设置对应值
            log.setId(UUID.randomUUID().toString());
            log.setCreateDate(new Date());
            log.setRemoteAddr(StringUtils.getRemoteAddr(request));
            log.setRequestUri(request.getRequestURI());
            log.setMethod(request.getMethod());
            log.setMenu(jp.getSignature().getDeclaringType().getSimpleName() + ":" + jp.getSignature().getName());
            log.(JSON.toJSONString(jp.getArgs()));
            if(log.getParams() != null && log.getParams().length() > 1024*10){
                log.setParams("参数过大无法保存。");
            }
                 // 获取当前用户
            String loginAccount = SecurityUtils.getCurrentUserLogin().get();
            UserInfo userInfo = userInfoService.getUserInfoByLoginAcount(loginAccount);
              if (userInfo != null) {
                  log.setUserId(userInfo.getId());
              }

            log.setType("1");

            result = jp.proceed();
        } catch (Throwable e) {
            log.setException(e.getMessage());
        }
        logService.addLog(log);
        return result;
    }

}
*/

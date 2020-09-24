package log;/*
package log;


import com.boot.boot.model.Asp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

*/
/**
 * 功能描述:
 * @auther: fuyuan
 * @date: 2020/4/29 0029 10:46
 */

/*@Component
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private long startTime = 0;
    private long endTime = 0;
    private String strMethodName = "";
    private String method = null;
    private String strClassName = "";
    private String args = "";
    private String clientIp = "127.0.0.1";

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void cutController() {
    }*/



/**
     * 前置通知：目标方法执行之前执行以下方法体的内容
     * @param jp
     *//*

    @Before("cutController()")
    public void beforeMethod(JoinPoint jp){
        startTime = System.currentTimeMillis();
         strMethodName = jp.getSignature().getName();


        System.out.println("【前置通知】the method 【" + strMethodName + "】 begins with " + Arrays.asList(jp.getArgs()));
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //URL
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //类方法
        logger.info("class_method={}", jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName());
        //参数
        logger.info("args={}", jp.getArgs());


    }

    */
/**
     * 返回通知：目标方法正常执行完毕时执行以下代码
     * @param jp
     * @param result
     *//*

    @AfterReturning(value="execution(* com.boot.boot.controller.*.*(..))",returning="result")
    public void afterReturningMethod(JoinPoint jp, Object result){
        String methodName = jp.getSignature().getName();
        System.out.println("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】");
    }

    */
/**
     * 后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
     * @param jp
     *//*

    @After("execution(* com.boot.boot.controller.*.*(..))")
    public void afterMethod(JoinPoint jp){
        endTime = System.currentTimeMillis();
        System.out.println("【后置通知】this is a afterMethod advice...");
        long totalMillis = endTime - startTime;
        logger.info("----" + "执行时间：" + totalMillis + "毫秒" + "----");
    }

    */
/**
     * 异常通知：目标方法发生异常的时候执行以下代码
     *//*

    @AfterThrowing(value="execution(* com.boot.boot.controller.*.*(..))",throwing="e")
    public void afterThorwingMethod(JoinPoint jp, NullPointerException e){
        String methodName = jp.getSignature().getName();
        System.out.println("【异常通知】the method 【" + methodName + "】 occurs exception: " + e);
    }

   */
/**
    * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
    * @return
    *//*

   @Around(value="execution(* com.boot.boot.controller.*.*(..))")
   public Object aroundMethod(ProceedingJoinPoint jp){
        method = jp.getSignature().getName();
       strClassName = jp.getTarget().getClass().getName();

       HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
       clientIp = request.getRemoteAddr();

       System.out.println(strClassName );//类
       System.out.println(clientIp );//类

       Object result = null;
       try {
           System.out.println("【环绕通知中的--->前置通知】：the method 【" + method + "】 参数: " + Arrays.asList(jp.getArgs()));

           result = jp.proceed();
           System.out.println("【环绕通知中的--->返回通知】：the method 【" + method + "】 返回值： " + result);
       } catch (Throwable e) {
           System.out.println("【环绕通知中的--->异常通知】：the method 【" + method + "】 异常： " + e);
       }

       System.out.println("【环绕通知中的--->后置通知】：-----------------end.----------------------");

       Method method = ((MethodSignature) jp.getSignature()).getMethod();
       Asp asp = method.getAnnotation(Asp.class);
       System.out.println( "注解："+asp.value());

       return result;
   }





}*/

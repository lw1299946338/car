package com.example.car.util.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 日志切面
 */
@Component
@Aspect
@Slf4j
public class LogAopAction {

    private static final Logger logger = LoggerFactory.getLogger(LogAopAction.class);


    /**
     * 声明切入点，凡是使用SystemLog的方法均被拦截
     */
    @Pointcut("@annotation(com.example.car.util.aop.SystemLog)")
    public void log(){
        logger.info("这里是一个切入点");
    }



    /**
     * 前置通知（Before advice） ：在某连接点（JoinPoint）之前执行的通知，但这个通知不能阻止连接点前的执行
     */
    //@Before("log()")
    //public void doBefore(JoinPoint joinPoint){
    //    logger.info("==============================前置通知==============================");
    //}


    /**
     * 结束执行(After就是在切入点之后执行)
     */
    //@After("log()")
    //public void afterExec(JoinPoint joinPoint){
    //    logger.info("==============================后置通知==============================");
    //}


    /**
     * 环绕通知
     */
    @Around("log()")
    public Object aroundExec(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("==============================执行开始==============================");
        long startTime = System.currentTimeMillis();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Object obj = null;
        //获取用户
//        User user = (User) session.getAttribute("user");
        try {
            logger.info("请求方法：" + pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName()+"()");
            SystemLog systemLog = getControllerMethodDescription(pjp);
            logger.info("模块描述：" + systemLog.module());
            logger.info("方法描述：" + systemLog.methods());
            Object[] os = pjp.getArgs();//获取方法的参数
            for (int i = 0; i < os.length; i++) {
                /*
                 * 去掉拦截的方法中的某些参数打印(如：ServletRequest，ServletRequest等)
                 * 如有需要不打印参数，可以继续补充到if判断中
                 */
                if(isParam(os[i])){
                    continue;
                }
                logger.info("参数[" + i + "]:" + JSON.toJSONString(os[i]));
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("====方法执行异常====");
            logger.error("异常信息:{}", e.getMessage());
        }
        logger.info("******************************进入方法*****************************");
        Object object = pjp.proceed();
        logger.info("*****************************执行方法结束***************************");
        logger.info("出参：" + JSON.toJSONString(object));
        long endTime = System.currentTimeMillis();
        logger.info("==============================执行结束，耗时：" + (endTime-startTime) + "ms==============================");
        return object;
    }
    /**
     * 方法有异常时的操作
     */
    @AfterThrowing(pointcut = "log()",throwing = "e")
    public void doAfterThrow(Exception e){
        logger.error("==============================异常通知==============================");
        logger.error("异常信息:{}", e.getMessage());
    }


    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     */
    public SystemLog getControllerMethodDescription(ProceedingJoinPoint pjp)  throws Exception {
        SystemLog systemLog = null;

        // 拦截的实体类，就是当前正在执行的controller
        Object target = pjp.getTarget();
        // 拦截的方法名称。当前正在执行的方法
        String methodName = pjp.getSignature().getName();
        // 拦截的放参数类型
        Signature sig = pjp.getSignature();
        MethodSignature msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();

        // 获得被拦截的方法
        Method method = null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(null != method){
            if(method.isAnnotationPresent(SystemLog.class)){
                systemLog = method.getAnnotation(SystemLog.class);
            }
        }

        return systemLog;
    }


    /**
     * 判断对象类型是否属于这些类
     * @param o
     * @return 类型符合则返回true，反之返回false
     */
    private boolean isParam(Object o){
        if(o instanceof ServletRequest || o instanceof HttpServletRequest || o instanceof HttpSession){
            return true;
        }
        return false;
    }


}

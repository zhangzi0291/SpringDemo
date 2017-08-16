package com.demo.aspect;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.demo.base.DaoException;
import com.demo.base.security.entity.SysUsers;
import com.demo.ip.entity.SysIp;
import com.demo.ip.service.IpService;
import com.demo.util.HttpUtil;

@Aspect    
@Component
public class AddLogAspect {
	
  
    private static final Logger logger = LoggerFactory.getLogger(AddLogAspect.class);
    @Resource
    private IpService ipService;
    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * 
     * @param joinPoint
     *            切点
     * @return 方法描述
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Map<String, String> getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        Map<String, String> returnMap = new HashMap();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String value = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    value = method.getAnnotation(AddLog.class).value();
                    break;
                }
            }
        }
        returnMap.put("value", value);
        return returnMap;
    }

    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     * 
     * @param joinPoint
     *            切点
     */
    @Before("@annotation(com.demo.aspect.AddLog)")
    public void after(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        SysIp ipinfo = new SysIp();
        ipinfo.setIpAddress(HttpUtil.getIpAddress(request));
        ipinfo.setUpdateTime(new Date());
        try {
            SysUsers user = (SysUsers) request.getSession().getAttribute("user");
            ipinfo.setUserName(user.getUserAccount());
        } catch (Exception e) {
            logger.error("Exception ", e);
        }
        try {
            String value = (getControllerMethodDescription(joinPoint).get("value")).toString();
            ipinfo.setRemark(value);
            ipService.insertSelective(ipinfo);
        } catch (Exception e) {
            logger.error("Exception ", e);
        }
    }

    @Pointcut("@annotation(com.demo.aspect.AddLog)")  
    public void controllerAspect() {  
    }  
    
    @AfterThrowing(pointcut="within(com.demo..*)",throwing="ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        SysIp ipinfo = new SysIp();
        ipinfo.setIpAddress(HttpUtil.getIpAddress(request));
        ipinfo.setUpdateTime(new Date());
        String methonName = joinPoint.getSignature().getName();
        String packageName = joinPoint.getSignature().getDeclaringTypeName();
        String remark = packageName + "." + methonName + " 产生了一个错误 " + ex;
        ipinfo.setRemark(remark);
        try {
            ipService.insertSelective(ipinfo);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
    }
}

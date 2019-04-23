package com.example.car.redis;


import com.alibaba.fastjson.JSON;
import com.example.car.util.MD5Utils;
import com.example.car.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Redis缓存AOP
 * @author zhanghuibo
 *
 */
@Aspect
@Component
@Slf4j
@Transactional(propagation= Propagation.NOT_SUPPORTED)
public class RedisCacheAop {
	
	public static final String CORE_KEY = "PINGTAI";
	@Autowired
	private RedisCacheUtil<Object> redisCacheUtil;
	
	@Pointcut("@annotation(com.example.car.redis.RedisCache)")
	public void redisCachePointcut() {} 
	/**
	 * service
	 */
	
	@Around(value="com.example.car.redis.RedisCacheAop.redisCachePointcut()&&@annotation(redisCache)",argNames="redisCache")
	public Object cachedMed(ProceedingJoinPoint pjp , RedisCache redisCache) throws Throwable {
		StringBuffer key = new StringBuffer();
		if(StringUtils.isNotBlank(redisCache.dataType())){
			key.append(redisCache.dataType()).append(":");
		}
		if(StringUtils.isNotBlank(redisCache.key()) && redisCache.key().length() > 0){
			key.append(redisCache.key());
		}else{
			key.append(getCacheKey(pjp, redisCache));
		}
		log.info("生成的Key2=============>"+key);
		
		if(redisCache.type()){
			redisCacheUtil.delete(key.toString());
			try{
				pjp.proceed();
			}catch(Exception e){
				log.error("redis AOP 异常日志：", e);
			}
			return null;
		}else{
			int time = redisCache.expire();
			log.info("超时时长time:=========>"+time);
//			Object object = RedisUtil.getObject(key.toString());
			Object object=redisCacheUtil.getCacheObject(key.toString());
			if(null != object) {
				log.info("RedisCach缓存已经存在");
				return object;
			}
			
			log.info(key+"缓存中没有，执行数据库操作.....");
			try{
				object = pjp.proceed();
			}catch(Exception e){
				log.error("redis AOP 异常日志：", e);
			}
			if(null == object){return null;}
			
			//RedisUtil.setObj(key.toString(), object, time);
            if(time>0){
                redisCacheUtil.setCacheObject(key.toString(), object,time);
            }else{
                redisCacheUtil.setCacheObject(key.toString(), object);
            }
			return object;
		}
		
	}
	
	/**
	 * 获取缓存的key值
	 * @param pjp
	 * @param cache
	 * @return
	 */
	private String getCacheKey(ProceedingJoinPoint pjp, RedisCache cache) {

		StringBuilder bf=new StringBuilder();  
		bf.append(pjp.getSignature().getDeclaringTypeName()).append(".").append(pjp.getSignature().getName());  
		Object[] args1=pjp.getArgs();  
		for(Object arg:args1) {  
			bf.append(".").append(JSON.toJSONString(arg));
		}  
		log.info("未加密前Key============="+bf.toString());
		return MD5Utils.string2MD5(bf.toString());
		//return MD5Utils.string2MD5(bf.toString());
	}
}

package com.example.car.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类
 * @author liwei
 * @date 2019/3/4 3:06 PM
 */
@Configuration
public class RedisConfig {

    @Bean(name="redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        RedisSerializer<String> key = new StringRedisSerializer();
        RedisSerializer<Object> value = new GenericJackson2JsonRedisSerializer();
        template.setConnectionFactory(factory);
        //key序列化方式
        template.setKeySerializer(key);
        //value序列化
        template.setValueSerializer(value);
        //value hashmap序列化
        template.setHashValueSerializer(value);
        //key haspmap序列化
        template.setHashKeySerializer(key);

        return template;
    }
}

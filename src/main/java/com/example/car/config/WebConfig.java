package com.example.car.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * WebMvc配置类
 * @author liwei
 * @date 2019/3/4 2:58 PM
 **/
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    /**
     * 配置资源路径扫描
     * @author liwei
     * @date 2019/3/4 2:39 PM
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //注册资源文件扫描路径
        registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        super.addResourceHandlers(registry);
    }

    /**
     * 解决跨域
     * @author liwei
     * @date 2019/3/4 2:38 PM
     **/
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }

//    @Override
//    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
//        ObjectMapper objectMapper = builder.build();
//        SimpleModule simpleModule = new SimpleModule();
//        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
//        objectMapper.registerModule(simpleModule);
//        // 忽略 transient 修饰的属性
//        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
//        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
//        super.configureMessageConverters(converters);
//    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
       // AuthenticationInterceptor bean = SpringUtils.getBean("authenticationInterceptor");
        //registry.addInterceptor(bean).addPathPatterns("/**")
          //      .excludePathPatterns("/swagger*/**").excludePathPatterns("v2/api-docs*/**");
        super.addInterceptors(registry);
    }

}

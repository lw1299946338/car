package com.example.car.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 数据源配置类
 * @author liwei
 * @date 2019/2/27 2:44 PM
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages ={"com.example.car.*.mapper"},sqlSessionFactoryRef="sqlSessionFactoryBean1" )
public class DataSourceOne {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ConfigurationProperties(prefix = "spring.datasource1")
    @Bean(name = "dataSource1")
    @Primary
    public DataSource dataSource1() {
        log.info("初始化dataSource1");
        return new HikariDataSource();
    }

    @Bean(name = "sqlSessionFactoryBean1")
    @Primary
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier(value = "dataSource1") DataSource dataSource,
                                                   @Qualifier(value = "globalConfig")GlobalConfig globalConfig,
                                                   PaginationInterceptor paginationInterceptor) throws Exception {
        log.info("初始化sqlSessionFactoryBean1");
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        Interceptor[] interceptors = new Interceptor[]{paginationInterceptor};
        bean.setPlugins(interceptors);
        bean.setGlobalConfig(globalConfig);
        bean.setTypeAliasesPackage("com.loan.stages.**.model");
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:spring/mybatis-config.xml"));
//        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapping/**/*Mapper.xml");
//        bean.setMapperLocations(resources);
        return bean.getObject();
    }

    @ConfigurationProperties(prefix = "global-config1")
    @Bean(name = "globalConfig")
    public GlobalConfig globalConfiguration1() {
        log.info("初始化globalConfiguration1");
        return new GlobalConfig();
    }

    @Bean(name = "transactionManager1")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager1(@Qualifier("dataSource1") DataSource dataSource) {
        log.info("初始化transactionManager1");
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "SqlSessionTemplateOne")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactoryBean1") SqlSessionFactory sqlSessionFactory) {
        log.info("初始化SqlSessionTemplateOne");
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}


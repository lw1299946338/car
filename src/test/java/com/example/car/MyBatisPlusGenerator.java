package com.example.car;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;


/**
 * @program xinsiwei
 * @description: 代码逆向生成工具
 * @author: liwei
 * @create: 2018/10/11 5:25 PM
 */
public class MyBatisPlusGenerator extends BaseTest {

    @Value("${spring.datasource1.jdbc-url}")
    String url ;

    @Value("${spring.datasource1.username}")
    String username ;

    @Value("${spring.datasource1.password}")
    String password ;

    String driverName = "com.mysql.jdbc.Driver";


    String controllerName = "controller";
    String entityName = "model";
    String xmlName = "mapping";
    String author = "liwei";
    String [] tablePrefixs = {"t"};
    String outputDir = "E:/IdeaProjects/car/src/main/java";


    @Test
    public void generateCode() {
        String packageName = "com.example.car.driver";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService

        generateByTables(serviceNameStartWithI, packageName, "t_order");
    }
    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();

        String dbUrl = url;
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername(username)
                .setPassword(password)
                .setDriverName(driverName);
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                //.setDbColumnUnderline(true)
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames)//修改替换成你需要的表名，多个表名传数组
                .setTablePrefix(tablePrefixs);// 此处可以修改为您的表前缀


        // 字段名生成策略
        //strategyConfig.setFieldNaming(NamingStrategy.underline_to_camel);
        //strategyConfig.setSuperServiceImplClass("com.baomidou.springwind.service.support.BaseServiceImpl");

        config.setBaseResultMap(true)
                .setFileOverride(true)
                .setActiveRecord(true)// 开启 activeRecord 模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setAuthor(author)
                .setOutputDir(outputDir)
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController(controllerName)
                                .setEntity(entityName)
                                .setXml(xmlName)

                ).execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}

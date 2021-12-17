/*
package com.boot.boot.config.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.boot.boot.mapper.mapper1", sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DataSourceConfig1 {



  datasource:
    db1: # 数据源1
      url: jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useUnicode=true&serverTimezone=Asia/Shanghai
      username: root
      password: 123456
      #       <!-- 配置获取连接等待超时的时间 -->
      maxWait: 60000
      initialSize : 1
      maxActive : 20
      minIdle : 5
      #回收时间
      minEvictableIdleTimeMillis: 30000
      driverClass: com.mysql.cj.jdbc.Driver
      #每个连接sql 数量
      maxPoolPreparedStatementPerConnectionSize: 20
      queryTimeout: 5000
      #       <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
      timeBetweenEvictionRunsMillis: 60000
      validationQuery : select 1 from dual
# 通过connectProperties属性来打开mergeSql功能；慢SQL记录
      connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000



    db2: # 数据源2
      url: jdbc:mysql://localhost:3306/test1?characterEncoding=utf8&useUnicode=true&serverTimezone=Asia/Shanghai
      username: root
      password: 123456
      maxWait: 60000
      initialSize : 1
      maxActive : 20
      minIdle : 5
      validationQuery : select 1 from dual
      #回收时间
      minEvictableIdleTimeMillis: 30000
      driverClass: com.mysql.cj.jdbc.Driver
      #每个连接sql 数量
      maxPoolPreparedStatementPerConnectionSize: 20
      queryTimeout: 5000
       #       <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
      timeBetweenEvictionRunsMillis: 60000



    private static final String MAPPER_XML = "classpath*:mapper/mapper1/*.xml";


    @Primary // 表示这个数据源是默认数据源, 这个注解必须要加，因为不加的话spring将分不清楚那个为主数据源（默认数据源）
    @Bean("db1DataSource")
    //读取application.yml中的配置参数映射成为一个对象
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource getDb1DataSource() {
        return new DruidDataSource();
    }


    @Primary
    @Bean("db1SqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // mapper的xml形式文件位置必须要配置，不然将报错：no statement （这种错误也可能是mapper的xml中，namespace与项目的路径不一致导致）
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML));

        org.apache.ibatis.session.Configuration configuration = bean.getObject().getConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);
        return bean.getObject();
    }

    @Primary
    @Bean("db1SqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}*/

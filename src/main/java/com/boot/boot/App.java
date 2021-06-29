package com.boot.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author fuyuan
 * @Description
 **/
@SpringBootApplication
@MapperScan("com.boot.boot.mapper")
//@ImportResource(locations = {"classpath:quartz-triggers.xml"})
@EnableCaching   //开启缓存
@EnableTransactionManagement

@EnableScheduling  // boot 定时任务
@EnableRabbit // 启用@RabbitListener

public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);


    }


}

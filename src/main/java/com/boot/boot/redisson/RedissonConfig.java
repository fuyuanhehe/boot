package com.boot.boot.redisson;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: fuyuan
 * @Date: 2019年03月12日  17:47
 * @Description:
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient getRedisson() {
        Config config = new Config();

        //  config.setLockWatchdogTimeout(5000);
        //单机模式  依次设置redis地址和密码

        config.useSingleServer().
                setAddress("redis://127.0.0.1:6379");


        return Redisson.create(config);
    }
}

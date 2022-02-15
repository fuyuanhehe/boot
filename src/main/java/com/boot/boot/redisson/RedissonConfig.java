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


   /*     Config config2 = new Config();
        config2.useClusterServers()
                .setScanInterval(2000) // 集群状态扫描间隔时间，单位是毫秒
                //可以用"rediss://"来启用SSL连接
                .addNodeAddress("redis://127.0.0.1:7000","redis://127.0.0.1:7001")
                .addNodeAddress("redis://127.0.0.1:7002");
        RedissonClient redisson = Redisson.create(config);*/

        return Redisson.create(config);
    }
}

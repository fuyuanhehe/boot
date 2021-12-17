package com.boot.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author fuyuan
 * @Description
 * @Date 17:35 2021/11/3
 * @Param
 * @return
 **/
@Component
@Slf4j
public class TestFactory {

    Map<String, testService> serviceMap = new ConcurrentHashMap<>();

    @Autowired
    List<testService> testServiceList;


    @PostConstruct
    public void init() {

        for (testService testService : testServiceList) {
            serviceMap.put(testService.getClass().getSimpleName(), testService);
        }

      /*  for (Map.Entry<String, testService> stringtestServiceEntry : serviceMap.entrySet()) {
           // log.error("key{},value{}", stringtestServiceEntry.getKey(), stringtestServiceEntry.getValue());

        }*/


    }

}

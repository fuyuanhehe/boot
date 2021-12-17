package com.boot.boot.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name = "test----2", url = "https://www.baifubao.com/callback?cmd=1059&callback=phone&phone=18782025848")

@FeignClient(name = "test----2", url = "http://127.0.0.1:9000")
public interface testServiceFeig {

    @RequestMapping("/hello")
    String hello(@RequestBody String str);


}

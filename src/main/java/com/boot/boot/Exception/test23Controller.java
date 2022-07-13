package com.boot.boot.Exception;


import com.boot.boot.logger.UserOperLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class test23Controller {


    @RequestMapping("test23")
    public UserOperLogger test2(@Valid UserOperLogger userOperLogger) {

        if (userOperLogger.getIpAddr() == null) {
            throw new APIException(AppCode.APP_ERROR, "业务异常222");
        }

        return userOperLogger;
    }


    @NotControllerResponseAdvice
    @RequestMapping("test24")
    public String test2() {


        return "hhhh";
    }

}

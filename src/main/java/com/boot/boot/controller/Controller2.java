package com.boot.boot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/user")
@Api(value = "用户类")
public class Controller2 {


    //	http://localhost:9090/swagger-ui.html#/
    @RequestMapping(value = "/get22")
    @ResponseBody
    @ApiOperation(value = "测试get", notes = "测试get2")
    @ApiParam(name = "a", value = "字符串a", required = true)
    @ApiImplicitParam(name = "a", value = "字符串a", required = true, dataType = "String", paramType = "Obj")
    public Object get231a(String a) {

        return a;
    }
/*	@Api：修饰整个类，描述Controller的作用
	@ApiOperation：描述一个类的一个方法，或者说一个接口
	@ApiParam：单个参数描述
	@ApiModel：用对象来接收参数
	@ApiProperty：用对象接收参数时，描述对象的一个字段
	@ApiResponse：HTTP响应其中1个描述
	@ApiResponses：HTTP响应整体描述
	@ApiIgnore：使用该注解忽略这个API
	@ApiError ：发生错误返回的信息
	@ApiParamImplicitL：一个请求参数
	@ApiParamsImplicit 多个请求参数*/

/*
	@RequestMapping(value = "/test")
	@RequiresRoles(value= {"admin"})
	@RequiresPermissions(value= {"add","del"})
	public String test(){

		return "redirect:/success.jsp";
	}*/


}

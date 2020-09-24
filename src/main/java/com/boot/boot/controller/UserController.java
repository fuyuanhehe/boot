package com.boot.boot.controller;

import com.boot.boot.model.User;
import com.boot.boot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;


@Controller
@RequestMapping(value = "/user")
@Api(value = "用户类")
public class UserController {

	@Resource
	UserService userService;

	@ApiIgnore//使用该注解忽略这个API
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	@ResponseBody
	public String  jsonTest() {
		return " hi you!";
	}
//	http://localhost:9090/swagger-ui.html#/
	@RequestMapping(value = "/get22")
	@ResponseBody
	@ApiOperation(value="测试get", notes="测试get2")
	@ApiParam(name = "a",value = "字符串a",required = true)
	@ApiImplicitParam(name = "a",value = "字符串a",required = true,dataType = "String",paramType = "Obj")
	 public Object get231a(String a){
		//System.out.println(SpringUtil.getBean("users22"));
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

	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public void registerUser(String username,String password){
		Md5Hash md5HashPassword = new Md5Hash(password,username,1);
		User user = new User();
		user.setUsername(username);
		user.setPassword(md5HashPassword.toString());
		user.setSalt(username);
		userService.insertUser(user);
	}



	@RequestMapping(value = "/subLogin" ,method = RequestMethod.POST)
	public String login(String username,String password,boolean rememberMe){

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		token.setRememberMe(rememberMe);

		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			return e.getMessage();
		}
		return "redirect:/success.jsp";
	}

	@RequestMapping(value = "/test")
	@RequiresRoles(value= {"admin"})
	@RequiresPermissions(value= {"add"})
	public String test(){

		return "redirect:/success.jsp";
	}

	@RequestMapping(value = "/test2")
	@RequiresRoles(value= {"admin","user"})
	public String tes2t(){

		return "redirect:/success.jsp";
	}

	@RequestMapping(value = "/test3")
	@RequiresPermissions(value= {"add","del"})
	public String tes3(){

		return "redirect:/success.jsp";
	}

	@RequestMapping(value = "/test4")
	@RequiresRoles(value= {"superme"})
	public String test4(){

		return "redirect:/success.jsp";
	}

	@RequestMapping(value = "/test5")
	@RequiresPermissions(value= {"query"})
	public String test5(){

		return "redirect:/success.jsp";
	}

}

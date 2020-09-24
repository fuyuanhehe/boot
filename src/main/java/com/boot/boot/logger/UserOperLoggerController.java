package com.boot.boot.logger;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.boot.boot.page.Page;
import com.boot.boot.page.PageRequest;
import com.boot.boot.util.ResponseMsg;
import com.boot.boot.logger.UserOperLoggerService;

@RestController
@RequestMapping("/operlog")
public class UserOperLoggerController {

	private Logger logger = LoggerFactory.getLogger(UserOperLoggerController.class);

	@Autowired
	private UserOperLoggerService userOperLoggerService;

	@RequestMapping(value = "/multi", method = {RequestMethod.GET,RequestMethod.POST})
	public ResponseMsg<List<UserOperLogger>> findOperLogger( UserOperLogger userOperLogger,
			@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
		ResponseMsg<List<UserOperLogger>> resp = new ResponseMsg<List<UserOperLogger>>();
		try {
			Page<UserOperLogger> pagedLogger = userOperLoggerService.findAllUserOperLogger(userOperLogger,
					new PageRequest(page, rows));
			resp.success("分页查询用户操作日志成功");
			resp.setData(pagedLogger.getRecords());
			resp.setTotal(pagedLogger.getTotalRows().intValue());
		} catch (Exception e) {
			logger.error("{}出现异常：{}", UserOperLoggerController.class.getSimpleName(), e.getMessage());
			resp.fail("分页查询用户操作日志失败");
		}
		return resp;
	}

	@RequestMapping(value = "/single", method = {RequestMethod.GET,RequestMethod.POST})
	public ResponseMsg<UserOperLogger> findOperLogger(@RequestParam("id") String id) {
		ResponseMsg<UserOperLogger> resp = new ResponseMsg<UserOperLogger>();
		try {
			if (id == null || id.trim().length() == 0)
				throw new NullPointerException("ID不能为空");
			UserOperLogger singleUserOperLog = userOperLoggerService.findSingleUserOperLog(id);
			resp.success("根据ID查询用户操作日志成功");
			resp.setData(singleUserOperLog);
		} catch (Exception e) {
			logger.error("{}出现异常：{}", UserOperLoggerController.class.getSimpleName(), e.getMessage());
			resp.fail("根据ID查询用户操作日志失败");
		}
		return resp;
	}

	@RequestMapping(value = "/add",method = {RequestMethod.GET,RequestMethod.POST})
	public ResponseMsg<String> addOperLogger( UserOperLogger userOperLogger) {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			userOperLoggerService.addUserOperLogger(userOperLogger);
			resp.success("添加用户操作日志成功");
			resp.setData("添加用户操作日志成功");
		} catch (Exception e) {
			logger.error("{}出现异常：{}", UserOperLoggerController.class.getSimpleName(), e.getMessage());
			resp.fail("添加用户操作日志失败");
			resp.setData("添加用户操作日志失败");
		}
		return resp;
	}

	@RequestMapping(value = "/addTb",method = {RequestMethod.GET,RequestMethod.POST})
	public ResponseMsg<String> addOperLoggerTb() {
		ResponseMsg<String> resp = new ResponseMsg<String>();
		try {
			userOperLoggerService.addUserOperLoggerTb();
			resp.success("添加用户操作日志表成功");
			resp.setData("添加用户操作日志表成功");
		} catch (Exception e) {
			logger.error("{}出现异常：{}", UserOperLoggerController.class.getSimpleName(), e.getMessage());
			resp.fail("添加用户操作日志表失败");
			resp.setData("添加用户操作日志表失败");
		}
		return resp;
	}
}

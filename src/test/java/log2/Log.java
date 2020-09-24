/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package log2;

import java.util.Date;

/**
 * @Description: 日志类
 * @Author: 张润东
 * @CreateDate: 2019/5/2 21:30
 * @Version: 1.0.0
 */

public class Log{

	private String id;//主键
	private Integer userId;
	private Date createDate;//创建时间
	private String remoteAddr;//ip
	private String requestUri;//请求地址

	private String method;//方法
	private String params;//参数
	private String exception;//错误信息
	private String menu;//菜单

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Log{" +
				"id='" + id + '\'' +
				", userId=" + userId +
				", createDate=" + createDate +
				", remoteAddr='" + remoteAddr + '\'' +
				", requestUri='" + requestUri + '\'' +
				", method='" + method + '\'' +
				", params='" + params + '\'' +
				", exception='" + exception + '\'' +
				", menu='" + menu + '\'' +
				'}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
}
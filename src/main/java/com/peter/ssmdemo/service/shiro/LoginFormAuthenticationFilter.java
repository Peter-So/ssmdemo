/**   
* @Title: LoginFormAuthenticationFilter.java 
* @Package com.peter.ssmdemo.service.shiro 
* @Description: TODO(用一句话描述该文件做什么) 
* @author PeterSo  supei_slm@qq.com
* @date 2015年7月28日 下午8:03:05 
* @version V1.0   
*/
package com.peter.ssmdemo.service.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/** 
* @ClassName: LoginFormAuthenticationFilter 
* @Description: 重新实现FormAuthenticationFilter
* @author PeterSo  supei_slm@qq.com
* @date 2015年7月28日 下午8:03:05 
*/
public class LoginFormAuthenticationFilter extends FormAuthenticationFilter {

	private final Logger log = LoggerFactory.getLogger(LoginFormAuthenticationFilter.class);
	
	/**
	 * 重写 onLoginSuccess 方法，实现按SuccessUrl的配置跳转页面
	 */
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		log.info("用户 " + SecurityUtils.getSubject().getPrincipal().toString() + " 登陆成功");

		String url = this.getSuccessUrl();
		httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + url); // 页面跳转
		return false;
	}

}
/**   
 * @Title: UserController.java 
 * @Package com.peter.ssmdemo.controller 
 * @Description: UserController
 * @author PeterSo  supei_slm@qq.com
 * @date 2015年7月23日 下午11:17:28 
 * @version V1.0   
 */
package com.peter.ssmdemo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.peter.ssmdemo.entity.User;
import com.peter.ssmdemo.service.UserService;

/**
 * @ClassName: UserController
 * @Description: UserController
 * @author PeterSo supei_slm@qq.com
 * @date 2015年7月23日 下午11:17:28
 */
@Controller
public class UserController {

	static Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("login into ...");
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username, Model model) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
		return "user/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "../../index";
	}

	@RequestMapping(value = "/user/hello", method = RequestMethod.GET)
	public String helloWorld(Model model) {
		User u = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		model.addAttribute("user", u);
		logger.info("Info: " + JSON.toJSONString(u));
		logger.info("User HelloWorld Is Ok...");
		return "user/hello";
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public String getAll(Model model, @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize) {
		// pageHelper插件方式
		List<User> list = userService.getPage(pageNo, pageSize);
		model.addAttribute("page", new PageInfo<User>(list));
		
//		List<User> list = userService.getUserByPage(pageNo * pageSize, pageSize);
//		PageInfo<User> p = new PageInfo<User>();
//		p.setList(list);
//		p.setPageSize(pageSize);
//		p.setPageNum(pageNo-1);
//		model.addAttribute("page", new PageInfo<User>(list));
		logger.info("Info: " + JSON.toJSONString(list));
		logger.info("getAllUser Is Ok...");
		return "user/list";
	}
	
	/**
	 * 泛型转换json
	 * @return
	 */
	@RequestMapping(value = "/user/json")
	@ResponseBody
	public List<User> jsonList(){
		try {
			List<User> list = userService.getPage(1, 10);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

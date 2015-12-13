/**   
* @Title: UserService.java 
* @Package com.peter.ssmdemo.service 
* @Description: UserService
* @author PeterSo  supei_slm@qq.com
* @date 2015年7月23日 下午11:59:36 
* @version V1.0   
*/
package com.peter.ssmdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.peter.ssmdemo.dao.UserMapper;
import com.peter.ssmdemo.entity.User;

/** 
 * @ClassName: UserService 
 * @Description: UserService 
 * @author PeterSo  supei_slm@qq.com
 * @date 2015年7月23日 下午11:59:36 
 */
@Service
public class UserService extends BaseService<User> {
	
	@Autowired
	private UserMapper mapper;
	
	public User findByName(String nickname){
		return mapper.findByName(nickname);
	}
	
	public List<User> getUserByPage(int pageNo,int pageSize){
		return mapper.getUserByPage(pageNo, pageSize);
	}
	
	public List<User> getPage(int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return mapper.getPage();
	}

}

/**   
* @Title: UserMapper.java 
* @Package com.peter.ssmdemo.dao 
* @Description: 基于接口实现Mybatis 
* @author PeterSo  supei_slm@qq.com
* @date 2015年7月23日 下午11:27:25 
* @version V1.0   
*/
package com.peter.ssmdemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peter.ssmdemo.entity.Idiosyncrasy;
import com.peter.ssmdemo.entity.User;

import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName: UserMapper
 * @Description: 基于接口实现Mybatis
 * @author PeterSo supei_slm@qq.com
 * @date 2015年7月23日 下午11:27:25
 */
public interface UserMapper extends Mapper<User> {
	
	User findByName(String nickname);
	
	List<User> getUserByPage(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
	
	List<User> getPage();

	Idiosyncrasy getIdiosyncrasyById(Integer id);

}

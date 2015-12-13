/**   
* @Title: BaseService<T>.java 
* @Package com.peter.ssmdemo.service 
* @Description: 基础Service
* @author PeterSo  supei_slm@qq.com
* @date 2015年7月26日 下午11:51:47 
* @version V1.0   
*/
package com.peter.ssmdemo.service;

import tk.mybatis.mapper.common.Mapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: BaseService
 * @Description: 基础Service
 * @author PeterSo supei_slm@qq.com
 * @date 2015年7月26日 下午11:51:47
 */
@Service
public abstract class BaseService<T> {

	@Autowired
	protected Mapper<T> mapper;

	public int save(T entity) {
		return mapper.insert(entity);
	}

	public int delete(T entity) {
		return mapper.deleteByPrimaryKey(entity);
	}
	
	public T selectOne(T entity){
		return 	mapper.selectOne(entity);
	}

	public T selectByPrimaryKey(long id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 单表分页查询
	 *
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<T> selectPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		// Spring4支持泛型注入
		return mapper.select(null);
	}

}

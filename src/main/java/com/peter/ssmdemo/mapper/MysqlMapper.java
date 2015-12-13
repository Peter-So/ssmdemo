/**   
* @Title: MysqlMapper.java 
* @Package com.peter.ssmdemo.mapper 
* @Description: 自定义MysqlMapper接口 
* @author PeterSo  supei_slm@qq.com
* @date 2015年11月11日 下午11:26:15 
* @version V1.0   
*/
package com.peter.ssmdemo.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/** 
* @ClassName: MysqlMapper 
* @Description: 自定义MysqlMapper接口 
* @author PeterSo  supei_slm@qq.com
* @date 2015年11月11日 下午11:26:15 
*/
public interface MysqlMapper<T> extends Mapper<T>,MySqlMapper<T> {

}

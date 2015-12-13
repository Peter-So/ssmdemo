/**   
* @Title: Idiosyncrasy.java 
* @Package com.peter.ssmdemo.entity 
* @Description: 特质
* @author PeterSo  supei_slm@qq.com
* @date 2015年8月16日 上午11:22:17 
* @version V1.0   
*/
package com.peter.ssmdemo.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

/** 
* @ClassName: Idiosyncrasy 
* @Description: 特质
* @author PeterSo  supei_slm@qq.com
* @date 2015年8月16日 上午11:22:17 
*/
@Table(name="Idiosyncrasy")
@NameStyle(Style.normal)
public class Idiosyncrasy {
	
	@Id
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}

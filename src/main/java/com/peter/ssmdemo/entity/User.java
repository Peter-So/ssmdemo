/**   
* @Title: User.java 
* @Package com.peter.ssmdemo.entity 
* @Description: User
* @author PeterSo  supei_slm@qq.com
* @date 2015年7月23日 下午11:24:28 
* @version V1.0   
*/
package com.peter.ssmdemo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;


/** 
 * @ClassName: User 
 * @Description: User
 * @author PeterSo  supei_slm@qq.com
 * @date 2015年7月23日 下午11:24:28 
 */

@Table(name="User")
@NameStyle(Style.normal)
public class User {
	
	@Id
	private Long id;
	private String username;
	private String password;
	private String nickname;
	private boolean gender;
	private Integer age;
	private Date birthday;
	private String roles;
	@Transient
	private List<User> firends;
	@Transient
	private Idiosyncrasy idiosyncrasy;
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 将角色集合转换为Set
	 * @return
	 */
	public Set<String> getRoleSet() {
		String[] strs = roles.split(",");
		if(strs!=null&&strs.length>0){
			Set<String> rs = new HashSet<String>();
			for (String s : strs) {
				rs.add(s);
			}
			return rs;
		}
		return null;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	public List<User> getFirends() {
		return firends;
	}
	public void setFirends(List<User> firends) {
		this.firends = firends;
	}
	public Idiosyncrasy getIdiosyncrasy() {
		return idiosyncrasy;
	}
	public void setIdiosyncrasy(Idiosyncrasy idiosyncrasy) {
		this.idiosyncrasy = idiosyncrasy;
	}
	
	
}

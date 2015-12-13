/**   
* @Title: ShiroRealm.java 
* @Package com.peter.ssmdemo.service.shiro 
* @Description: 自定义ShiroRealm
* @author PeterSo  supei_slm@qq.com
* @date 2015年7月28日 下午8:01:15 
* @version V1.0   
*/
package com.peter.ssmdemo.service.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peter.ssmdemo.entity.User;
import com.peter.ssmdemo.service.UserService;


/** 
* @ClassName: ShiroRealm 
* @Description: 自定义ShiroRealm
* @author PeterSo  supei_slm@qq.com
* @date 2015年7月28日 下午8:01:15 
*/
public class ShiroRealm  extends AuthorizingRealm{
	
	private UserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(ShiroRealm.class);

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userService.findByName(token.getUsername());
		if (user != null) {
			//byte[] salt = Encodes.decodeHex(user.getSalt());
			setSession("user",user);
			return new SimpleAuthenticationInfo( user.getUsername(), user.getPassword(), getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		//ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		User user = userService.findByName(username);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(user.getRoleSet());
		return info;
	}
	
	/**
	 * 将用户设置到ShiroSession里面
	 * @param key  
	 * @param user
	 */
	protected void setSession(Object key,User user) {
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser != null){
			Session session = currentUser.getSession();
			log.debug("ShiroSession默认超时时间为[{}]毫秒",session.getTimeout());
			if(session != null){
				session.setAttribute(key, user);
				log.info("User into ShiroSession....");
			}
		}
	}

	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

}

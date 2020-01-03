package com.cxb.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.shop.exception.PasswordEarroException;
import com.cxb.shop.exception.UsernameExist;
import com.cxb.shop.exception.YanZhengmaException;
import com.cxb.shop.pojo.User;
import com.cxb.shop.service.UserinfoService;

@RestController
@RequestMapping(value="/userinfo")
public class UserinfoController {

	/**
	 * 0:验证码错误，1：注册成功，2：用户名已存在
	 */
	@Autowired
	UserinfoService userinfoService;
	
	@RequestMapping("doinsert")
	public Object doinsert(String logname,String password,String keycold,HttpSession session) throws UsernameExist{
		Map mp =new HashMap();
		String code=(String) session.getAttribute("rightCode");
		if(!keycold.equalsIgnoreCase(code)){
			mp.put("msg", 0);
			return mp;
		}
		userinfoService.getinster(logname, password);
		mp.put("msg", 1);
		return mp;
	}
	
	@RequestMapping("useronline")
	public Object userIsOnline(HttpSession session){
		
		User user=(User) session.getAttribute("user");
		return user;
	}
	
	/**
	 * 登录方法
	 * @param logname
	 * @param password
	 * @param keycode
	 * @param session
	 * @return msg: 0：用户不存在 ，1：正常， 2：密码错误，3：用户禁用  4：验证码错误
	 */
	@RequestMapping("doselect")
		public Object doselect(String logname,String password,String keycold,HttpSession session){
			
			Map mp=new HashMap();
			String code=(String) session.getAttribute("rightCode");
			
			if(!code.equalsIgnoreCase(keycold)){
				System.out.println(keycold+"--"+code);
				mp.put("msg",4);
				return mp;
			}
			try {
				//登录成功后 将 获取的user对象 放入 session 属性中 备用
				User user= userinfoService.getselect(logname, password);
				session.setAttribute("user",user);
				mp.put("msg",1);
			} catch (UsernameExist e) {
				mp.put("msg",0);
			} catch (PasswordEarroException e) {
				mp.put("msg",2);
			} catch (YanZhengmaException e) {
				mp.put("msg",3);
			}
			return mp;
		}
	
	
	
	
	
}

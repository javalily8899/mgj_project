package com.cxb.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.shop.exception.UsernameExist;
import com.cxb.shop.exception.PasswordEarroException;
import com.cxb.shop.exception.UserBeDisabledException;
import com.cxb.shop.exception.YanZhengmaException;
import com.cxb.shop.exception.UserrNameErroException;
import com.cxb.shop.pojo.Pos;
import com.cxb.shop.service.PosService;

@RestController
public class PosController {
	
	@Autowired
	PosService posService;
	
	@RequestMapping("/posselect")
	public Object selectPosController(Integer poaid) {
		return posService.selectAllpos(poaid);
		
	}
	
	@RequestMapping("/posonline")
	public Object userIsOnline(HttpSession session){
		
		Pos pos=(Pos) session.getAttribute("pos");
		//System.out.println(user);
		return pos;
	}
	
	
	
	@RequestMapping("/poslogin")
	/**
	 * 
	 * @param logname
	 * @param password
	 * @param keycode
	 * @param session
	 * @return  msg: 1 正常，  0  用户不存在  ，2  密码错误，3用户禁用  
	 */
	public Object doLogin(String logname,String password,String keycode,HttpSession session){
		
		Map msg=new HashMap();
		
		String code=(String) session.getAttribute("rightCode");
		
		if(!code.equalsIgnoreCase(keycode)){
			msg.put("msg",4);
			return msg;
		}
		
		
		try {
			//登录成功后 将 获取的user对象 放入 session 属性中 备用
			Pos pos= posService.doPosLogin(logname, password);
			session.setAttribute("pos",pos);
			msg.put("msg",1);
		} catch (UserrNameErroException e) {
			msg.put("msg",0);
		} catch (PasswordEarroException e) {
			msg.put("msg",2);
		} catch (UserBeDisabledException e) {
			msg.put("msg",3);
		}
		return msg;
	}
}

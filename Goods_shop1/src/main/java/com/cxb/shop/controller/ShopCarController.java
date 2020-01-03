package com.cxb.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.shop.pojo.Cart;
import com.cxb.shop.pojo.User;
import com.cxb.shop.service.ShopCarService;

@RestController
@RequestMapping(value="/shopcar")
public class ShopCarController {

	@Autowired
	ShopCarService shopCarService;
	
	@RequestMapping("doinsert")
	public Object doinsert(Cart cart,HttpSession session){
		User user = (User) session.getAttribute("user");
		cart.setUserid(user.getUserid());	
		shopCarService.insertshopcar(cart);
		return true;
	}
	/**
	 * 显示详细信息
	 * @param session
	 * @param pagenum
	 * @return
	 */
	@RequestMapping("showshopcar")
	public Object showshopcar(HttpSession session,Integer pagenum){
		User user = (User) session.getAttribute("user");
		Integer rowcount=8;
		List<Map> list = shopCarService.showshopcar(user,pagenum,rowcount);
		Integer pagecount = shopCarService.getCount(rowcount,user);
		Map mp=new HashMap();
		mp.put("array", list);
		mp.put("pagecount", pagecount);
		
		return mp;
	}
	@RequestMapping("changcountbyid")
	public Object changcountbyid(Integer ctid,Integer count){
		
		return shopCarService.changcountbyid(ctid, count);
	}
	
	
	
	
}

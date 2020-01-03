package com.cxb.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.shop.pojo.Goodssize;
import com.cxb.shop.service.GoodsinfoService;
@RestController
@RequestMapping(value="/goodsinfo")
public class GoodsinfoController {

	@Autowired
	GoodsinfoService goodsinfoService;
	
	@RequestMapping("getAllGoods")
	public Object getAllGoodsP(Integer pagenum){
		Integer rowcount=20;
		return goodsinfoService.getAllinfo(rowcount, pagenum);
	}
	@RequestMapping("getkeywordall")
	public Object getkeywordall(String keyword){
		StringBuffer buffer =new StringBuffer("%");
		buffer.append(keyword).append("%");
		return goodsinfoService.getkeyword(buffer.toString());
	}
	@RequestMapping("getGoodsbygdid")
	public Object getGoodsbygdid(Integer gdid){
		Map map = goodsinfoService.getGoodsbygdid(gdid);
		List<Goodssize> list = goodsinfoService.getGoodssize();
		Map mp=new HashMap();
		mp.put("good", map);
		mp.put("sizelist", list);
		return mp;
	}
	
	
	
}

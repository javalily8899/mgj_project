package com.cxb.shop.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxb.shop.mapper.AaBbgjzMapper;
import com.cxb.shop.mapper.AaGoodsinfoMapper;
import com.cxb.shop.mapper.GoodssizeMapper;
import com.cxb.shop.pojo.Goodssize;
@Service
public class GoodsinfoService {

	@Autowired
	AaGoodsinfoMapper goodsinfo;
	@Autowired
	AaBbgjzMapper gjzMapper;
	@Autowired
	GoodssizeMapper goodssizeMapper;
	
	public List<Map> getAllinfo(Integer rowcount,Integer pagenum ){

		RowBounds bounds=new RowBounds(((pagenum-1)*rowcount), rowcount);
		return goodsinfo.getGoodsInfo(bounds);

	}
//	根据关键字获取keyword信息(搜索框）
	public List<Map> getkeyword(String keyword){
	
		return gjzMapper.getByKeyWord(keyword);
	}
//	点击图片跳转页面
	public Map getGoodsbygdid(Integer gdid){
		
		return gjzMapper.getGoodsbyGdid(gdid);	 
	}
	
	public List<Goodssize> getGoodssize(){
			
		return goodssizeMapper.selectByExample(null);	 
	}
	
	
	
	
}

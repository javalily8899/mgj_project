package com.cxb.shop.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.shop.mapper.AaShopCarMapper;
import com.cxb.shop.mapper.CartMapper;
import com.cxb.shop.pojo.Cart;
import com.cxb.shop.pojo.CartExample;
import com.cxb.shop.pojo.User;

@Service
public class ShopCarService {
	@Autowired
	CartMapper cartMapper;

	@Autowired
	AaShopCarMapper aaShopCarMapper;
	@Transactional
	public void insertshopcar(Cart info){
		
		CartExample example=new CartExample();
		example.createCriteria().andUseridEqualTo(info.getUserid()).andGsidEqualTo(info.getGsid()).andGdidEqualTo(info.getGdid());
		List<Cart> car=cartMapper.selectByExample(example);
		if(car!=null&&car.size()==1){
			Cart ct=car.get(0);
			ct.setGdcount(ct.getGdcount()+info.getGdcount());
			cartMapper.updateByPrimaryKey(ct);
		}else{
			cartMapper.insert(info);
		}	
	}
	public List<Map> showshopcar(User user,Integer pagenum,Integer rowcount){
			
		RowBounds bounds=new RowBounds(((pagenum-1)*rowcount), rowcount);
		return aaShopCarMapper.getshopcar(bounds,user.getUserid());	
	}
	/**
	 * 根据每页行数 获取 总页数4
	 * @param rowcount 每页行数
	 * @return
	 */
	public Integer getCount(Integer rowcount,User user){
		
		Integer count=aaShopCarMapper.getCount(user.getUserid());	
		return (count%rowcount==0) ? (count/rowcount)  :  (count/rowcount)+1;
	}
	@Transactional
	public boolean changcountbyid(Integer ctid,Integer count){
		Cart ct= cartMapper.selectByPrimaryKey(ctid);
		if(ct!=null){
			if(count==0){
				return cartMapper.deleteByPrimaryKey(ctid)==1;
			}else{
				ct.setGdcount(count);
				return cartMapper.updateByPrimaryKey(ct)==1;
			}
		}
		return false;
	}
	
	
	
	
}

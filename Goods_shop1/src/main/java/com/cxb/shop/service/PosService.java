package com.cxb.shop.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.shop.exception.UsernameExist;
import com.cxb.shop.exception.PasswordEarroException;
import com.cxb.shop.exception.UserBeDisabledException;
import com.cxb.shop.exception.YanZhengmaException;
import com.cxb.shop.exception.UserrNameErroException;
import com.cxb.shop.mapper.PosMapper;
import com.cxb.shop.mapper.PosToolMapper;
import com.cxb.shop.pojo.Pos;
import com.cxb.shop.pojo.PosExample;

@Service
public class PosService {
	
	
	@Autowired
	PosMapper posMapper;
	
	@Autowired
	PosToolMapper posToolMapper;
	
	/**
	 * 获取店铺所有的商品
	 * @return poaid 店铺编号
	 */
	public List<Map> selectAllpos(Integer poaid) {
		return posToolMapper.getAllpos(poaid);	
	}
	
	
	
	/**
	 * 用户登录的方法
	 * @param logname  用户名
	 * @param password 密码
	 * @return 完整的用户信息对象
	 * @throws UsernameExist 用户已存在
	 * @throws UserrNameErroException  表示用户不存在
	 * @throws PasswordEarroException  密码错误
	 * @throws UserBeDisabledException 用户已经被禁用
	 */
	public Pos  doPosLogin(String logname,String password) throws UserrNameErroException, PasswordEarroException, UserBeDisabledException{
	
		 PosExample example=new PosExample();
		 example.createCriteria().andLognameEqualTo(logname);
		
		 List<Pos> pos=posMapper.selectByExample(example);
		 if(pos==null||pos.size()==0){
			 throw new UserrNameErroException();
		 }
		 
		 Pos poss=pos.get(0);
		 
		 if(poss.getStatus()!=1){
			 throw new UserBeDisabledException();
		 }
		 
		 Md5Hash md5=new Md5Hash(password,poss.getSalt());
		 
		 
		 if(!poss.getPassword().equals(md5.toString())){
			 throw new PasswordEarroException();
		 }
		 
		 return poss;
		
	}
	
	
	
	@Transactional
	public void doPosRegiste(String logname,String password) throws UsernameExist{
		
		
		PosExample example=new PosExample();
		//判断用户名是否以及被使用
		example.createCriteria().andLognameEqualTo(logname);
		int count= posMapper.countByExample(example);
		if(count==1){
			throw new UsernameExist();
		}
		
		//封装 user信息以及 salt 、密码加密等操作		
		Pos pos=new Pos();
		String salt=UUID.randomUUID().toString();
		Md5Hash md5=new Md5Hash(password,salt);
		
		pos.setLogname(logname);
		pos.setPassword(md5.toString());
		pos.setSalt(salt);
		pos.setPtid(1);
		pos.setStatus(1);
		
		posMapper.insert(pos);
		
	}
}

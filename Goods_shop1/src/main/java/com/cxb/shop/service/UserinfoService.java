package com.cxb.shop.service;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.shop.exception.PasswordEarroException;
import com.cxb.shop.exception.UsernameExist;
import com.cxb.shop.exception.YanZhengmaException;
import com.cxb.shop.mapper.UserMapper;
import com.cxb.shop.pojo.User;
import com.cxb.shop.pojo.UserExample;

@Service
public class UserinfoService {

	@Autowired
	UserMapper userMapper;
//	注册
	@Transactional
	public void getinster(String logname,String password) throws UsernameExist{
//		判断用户名是否已存在
		UserExample example =new UserExample();
		example.createCriteria().andLognameEqualTo(logname);
		 Long count = (long) userMapper.countByExample(example );
		 if(count==1){
			 throw new UsernameExist();
		 }
		 User user =new User();
		 String salt=UUID.randomUUID().toString();
		 Md5Hash md5=new Md5Hash(password, salt);
		 user.setLogname(logname);
		 user.setPassword(md5.toString());
		 user.setSalt(salt);
		 user.setStatus(1);
		 user.setUtid(1);
		 userMapper.insert(user);	 
	}
//	登录
	public User getselect(String logname,String password) throws UsernameExist, YanZhengmaException, PasswordEarroException{
		UserExample example =new UserExample();
		example.createCriteria().andLognameEqualTo(logname);
		List<User> list = userMapper.selectByExample(example );
		if(list==null||list.size()==0){
			 throw new UsernameExist();
		 }
		
		User user=list.get(0);
		if(user.getStatus()!=1){
			 throw new YanZhengmaException();
		 }
		 
		 Md5Hash md5=new Md5Hash(password,user.getSalt());
		 
		 
		 if(!user.getPassword().equals(md5.toString())){
			 throw new PasswordEarroException();
		 }
		 
		 return user;
	}
	
	
	
}

package com.cxb.shop.exception;

public class UsernameExist extends Exception{

	@Override
	public void printStackTrace() {
		System.out.println("用户名已存在");
	}
	
	
}

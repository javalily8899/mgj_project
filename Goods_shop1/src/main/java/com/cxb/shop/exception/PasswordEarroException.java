package com.cxb.shop.exception;

public class PasswordEarroException extends Exception{

	@Override
	public void printStackTrace() {
		System.out.println("密码错误");
	}
}

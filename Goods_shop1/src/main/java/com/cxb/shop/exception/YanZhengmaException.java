package com.cxb.shop.exception;

public class YanZhengmaException extends Exception{

	@Override
	public void printStackTrace() {
		System.out.println("验证码错误");
	}
}

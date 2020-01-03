package com.cxb.shop.exception;

public class UserrNameErroException extends Exception{

	@Override
	public void printStackTrace() {
		System.out.println("user is not  exsit");
	}
}

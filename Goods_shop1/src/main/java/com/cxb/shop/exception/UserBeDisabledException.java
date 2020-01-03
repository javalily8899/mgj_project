package com.cxb.shop.exception;

/**
 * 用户状态异常：禁用、过期等
 * @author Administrator
 *
 */
public class UserBeDisabledException extends Exception{

	@Override
	public void printStackTrace() {
		System.out.println("user is disabled");
	}
	
	
}

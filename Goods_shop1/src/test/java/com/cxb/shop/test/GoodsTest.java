package com.cxb.shop.test;

import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxb.shop.service.GoodsinfoService;
import com.cxb.shop.service.ShopCarService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication(scanBasePackages="com.cxb.shop")
@MapperScan(basePackages="com.cxb.shop.mapper")
public class GoodsTest {

	@Autowired
	ShopCarService shopCarService;

	@Test
	public void test1(){
		
		
		
	}
	
}

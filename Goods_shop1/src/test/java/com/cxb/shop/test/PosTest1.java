package com.cxb.shop.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxb.shop.service.PosService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PosTest1 {

	@Autowired
	PosService posService;
	
	@Test
	public void test1(){
		List<Map> map=posService.selectAllpos(1);
		for (Map map2 : map) {
			System.out.println(map2);
		}
	}
}

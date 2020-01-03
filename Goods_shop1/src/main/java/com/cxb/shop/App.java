package com.cxb.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages="com.cxb.shop")
@MapperScan(basePackages="com.cxb.shop.mapper")
public class App {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}


}

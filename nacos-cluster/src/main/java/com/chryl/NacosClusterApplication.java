package com.chryl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class NacosClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosClusterApplication.class, args);
	}


	@Autowired
	ConfigurableApplicationContext applicationContext;

	@GetMapping("configs")
	public Object getConfigw() {
		//读配置信息
		String username = applicationContext.getEnvironment().getProperty("common.username");
		String age = applicationContext.getEnvironment().getProperty("common.age");
		String addr = applicationContext.getEnvironment().getProperty("common.addr");
		String birthday = applicationContext.getEnvironment().getProperty("common.birthday");

		Map<String, String> resMap = new HashMap<>();
		resMap.put("username", username);
		resMap.put("age", age);
		resMap.put("addr", addr);
		resMap.put("birthday", birthday);

		return resMap;
	}
}

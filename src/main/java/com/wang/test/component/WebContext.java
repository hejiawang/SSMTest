package com.wang.test.component;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class WebContext {

	@PostConstruct
	public void init() {
		System.out.println("初始化操作....");
	}
}

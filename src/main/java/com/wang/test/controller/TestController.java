package com.wang.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wang.test.model.Test;
import com.wang.test.service.TestService;

@Controller
@RequestMapping("/testcontroller")
public class TestController extends BaseController {
	
	@Autowired
	private TestService testService;

	@RequestMapping(value = "/test")
	public void test(HttpServletResponse response) {
		ArrayList<Test> tests = testService.getAllTest();
		printJson(response, tests);
	}

}

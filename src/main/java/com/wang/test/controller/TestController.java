package com.wang.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
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

	@RequestMapping(value = "/getalltest")
	public void getAllTest(HttpServletResponse response) {
		
		ArrayList<Test> tests = testService.getAllTest();
		printJson(response, tests);
	}
	
	@RequestMapping(value = "/gettestbyid")
	public void getTestById(HttpServletRequest request, HttpServletResponse response) {
	
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		Test test = testService.getTestById(id);
		printJson(response, test);
	}

	@RequestMapping(value = "/addtest")
	public void addTest(HttpServletRequest request, HttpServletResponse response) {
		
		String idStr = request.getParameter("id");
		String name = request.getParameter("name");
		int id = Integer.parseInt(idStr);
		
		Test test = new Test();
		test.setId(id);
		test.setName(name);
		testService.addTest(test);
	}

	@RequestMapping(value = "/updatetestbyid")
	public void updateTestById(HttpServletRequest request, HttpServletResponse response) {
		
		String idStr = request.getParameter("id");
		String name = request.getParameter("name");
		int id = Integer.parseInt(idStr);
		
		testService.updateTestById(id, name);
	}

	@RequestMapping(value = "/deltestbyid")
	public void delTestById(HttpServletRequest request, HttpServletResponse response) {
		
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		testService.delTestById(id);
	}
}

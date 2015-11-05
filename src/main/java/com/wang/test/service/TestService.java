package com.wang.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wang.test.dao.TestDao;
import com.wang.test.model.Test;

@Component("testService")
public class TestService {

	@Autowired
	private TestDao testDao;

	public ArrayList<Test> getAllTest() {
		return testDao.getAllTest();
	}

}

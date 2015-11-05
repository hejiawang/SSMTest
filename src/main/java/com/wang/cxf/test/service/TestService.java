package com.wang.cxf.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wang.cxf.test.dao.TestDao;
import com.wang.cxf.test.model.Test;

@Component("testService")
public class TestService {

	@Autowired
	private TestDao testDao;

	public ArrayList<Test> getAllTest() {
		return testDao.getAllTest();
	}

}

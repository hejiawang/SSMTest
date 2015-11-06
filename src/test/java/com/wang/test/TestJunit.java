package com.wang.test;

import java.util.ArrayList;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wang.test.dao.TestDao;
import com.wang.test.model.Test;

public class TestJunit {
	
	private transient ApplicationContext context;
	private TestDao testDao;
	
	@Before
    public void initContext() {
		this.context = new ClassPathXmlApplicationContext("classpath:config/applicationContext-data.xml");
		testDao = (TestDao)context.getBean("testDao");
	}

	@org.junit.Test
	public void getAllTest(){
		ArrayList<Test> testList = testDao.getAllTest();
		for( int i=0; i<testList.size(); i++ ){
			System.out.println(testList.get(i));
		}
	}
	
	@org.junit.Test
	public void getTestById(){
		Test test = testDao.getTestById(2);
		System.out.println(test);
	}
	
	@org.junit.Test
	public void addTest(){
		Test test = new Test();
		test.setId(2);
		test.setName("test2");
		testDao.addTest(test);
	}
	
	@org.junit.Test
	public void updateTestById(){
		testDao.updateTestById( 4, "test44");
	}
	
	@org.junit.Test
	public void delTestById(){
		testDao.delTestById(3);
	}
	
	public TestDao getTestDao() {
		return testDao;
	}

	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
}

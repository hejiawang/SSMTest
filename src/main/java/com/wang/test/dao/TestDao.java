package com.wang.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.wang.test.model.Test;

public interface TestDao {

	public ArrayList<Test> getAllTest();

	public Test getTestById(int id);

	public void addTest(Test test);

	public void updateTestById(@Param("id") int id, @Param("name") String name);
	
	public void delTestById(int id);
}

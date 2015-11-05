package com.wang.cxf.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseController {
	
	/**
	 * 向jsp发送json数据
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param args
	 *            需要发送的内容
	 */
	protected void printJson(HttpServletResponse response, Object args) {

		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter pw = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String paramJson = mapper.writeValueAsString(args);
			pw = response.getWriter();
			pw.print(paramJson);
		} catch (IOException e) {
			// Log.error(TAG, e);
		} finally {
			if (null != pw) {
				pw.close();
			}
		}
	}
}	

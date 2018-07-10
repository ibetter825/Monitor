package com.monitor.core.web.servlet;

import javax.servlet.http.HttpServlet;

public class ConfigServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 381853424148858718L;

	/**
	 * 初始化servlet
	 */
	@Override
	public void init() {
		System.err.println("-----------初始化完成---------------");
	}
}
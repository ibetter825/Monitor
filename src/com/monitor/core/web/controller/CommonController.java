package com.monitor.core.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CommonController extends BaseController {
	
	/**
	 * 跳转到页面
	 * @param view
	 * @return
	 */
	@RequestMapping("/comm/{path}/{view}.html")
	public ModelAndView index(@PathVariable(value = "path") String path, @PathVariable(value = "view") String view) {
		return new ModelAndView(path+"/"+view);
	}
}

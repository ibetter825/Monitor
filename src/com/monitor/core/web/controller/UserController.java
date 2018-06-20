package com.monitor.core.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.monitor.core.service.UserService;

@RestController
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/list")
	public ModelAndView list() {
		return new ModelAndView(VIEW_CORE_PATH + "user/list");
	}
}

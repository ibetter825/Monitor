package com.monitor.core.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.monitor.core.service.UserService;

@RestController
public class LoginController extends BaseController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public ModelAndView index() {
		return new ModelAndView("login");
	}
}

package com.monitor.core.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.monitor.core.aop.annotation.Validator;
import com.monitor.core.bean.form.LoginForm;
import com.monitor.core.service.UserService;

@RestController
public class LoginController extends BaseController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	@Validator
	public ModelAndView dologin(@Valid LoginForm loginForm, BindingResult bindingResult){
		return new ModelAndView("redirect:/u/index");
	}
}

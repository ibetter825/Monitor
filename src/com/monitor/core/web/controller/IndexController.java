package com.monitor.core.web.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.collect.Maps;
import com.monitor.core.bean.entity.User;
import com.monitor.core.service.UserService;

@RestController
public class IndexController extends BaseController {
	@Autowired
	private UserService userService;
	@RequestMapping("/index")
	public ModelAndView index() {
		Map<String, Object> model = Maps.newHashMap();
		User user =	userService.getUser(10000);
		if(user != null)
			System.err.println(user.getUserName()+"--------------");
		model.put("user", user);
		return new ModelAndView(VIEW_CORE_PATH + "index", model);
	}
}

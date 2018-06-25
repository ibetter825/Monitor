package com.monitor.core.web.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.monitor.core.bean.entity.User;
import com.monitor.core.bean.model.PageModel;
import com.monitor.core.bean.rq.PagerRQ;
import com.monitor.core.bean.rq.QueryRQ;
import com.monitor.core.orm.Page;
import com.monitor.core.service.UserService;

@RestController
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public ModelAndView index() {
		return new ModelAndView(VIEW_CORE_PATH + "user/list");
	}
	
	/**
	 * 分页查询用户数据
	 * @param pager
	 * @param rq
	 * @return
	 */
	@RequestMapping("/user/list")
	public PageModel list(PagerRQ pager, QueryRQ rq) {
		Page<User> page = new Page<>(1, 1);
		Map<String, Object> values = rq.getQrq();
		if(!values.containsKey("userStatus"))
			values.put("userStatus", (short) 1);//默认查询有效数据
		String hql = rq.getHqlWithParam("from User", true);
		userService.getPageList(page, hql, values);
		PageModel pageModel = new PageModel(page);
		return pageModel;
	}
}

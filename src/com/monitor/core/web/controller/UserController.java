package com.monitor.core.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.monitor.core.aop.annotation.Validator;
import com.monitor.core.bean.constant.AuthConstant;
import com.monitor.core.bean.entity.User;
import com.monitor.core.bean.entity.UserInfo;
import com.monitor.core.bean.model.PageModel;
import com.monitor.core.bean.model.ResultModel;
import com.monitor.core.bean.rq.PagerRQ;
import com.monitor.core.bean.rq.QueryRQ;
import com.monitor.core.orm.Page;
import com.monitor.core.service.MapService;
import com.monitor.core.service.UserService;
import com.monitor.core.utils.DateUtil;
import com.monitor.core.utils.Md5Util;

@RestController
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private MapService mapService;
	
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
		Page<Map<?,?>> page = new Page<>();
		Map<String, Object> values = rq.getQrq();
		values.put("_u_userStatus", Short.valueOf((String) values.getOrDefault("_u_userStatus", "1")));
		
		String hql = rq.getHqlWithParam("select new map(u.userNo as userNo, u.userName as userName, i.nickName as nickName, u.userPhone as userPhone, u.userEmail as userEmail) from User u left join u.userInfo i ", true);
		mapService.getPageList(page, hql, values);
		PageModel pageModel = new PageModel(page);
		return pageModel;
	}
	
	@RequestMapping("/user/form")
	@Validator
	public ResultModel form(@Valid User user, @Valid UserInfo info, BindingResult bindingResult){
		if(user.getUserNo() == null){
			info.setAddTime(DateUtil.getDateByTime());
			user.setUserStatus((short)1);
			user.setUserSalt(AuthConstant.DEFAULT_USER_SALT);
			user.setUserPwd(Md5Util.md5(AuthConstant.DEFAULT_USER_PWD + AuthConstant.DEFAULT_USER_SALT));
		}
		ResultModel result = new ResultModel();
		userService.saveOrUpdate(user, info);
		return result;
	}
}

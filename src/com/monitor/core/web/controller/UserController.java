package com.monitor.core.web.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.monitor.core.aop.annotation.Validator;
import com.monitor.core.bean.constant.AuthConstant;
import com.monitor.core.bean.entity.Organ;
import com.monitor.core.bean.entity.Role;
import com.monitor.core.bean.entity.User;
import com.monitor.core.bean.entity.UserInfo;
import com.monitor.core.bean.model.PageModel;
import com.monitor.core.bean.model.ResultModel;
import com.monitor.core.bean.rq.PagerRQ;
import com.monitor.core.bean.rq.QueryRQ;
import com.monitor.core.orm.Page;
import com.monitor.core.service.MapService;
import com.monitor.core.service.OrganService;
import com.monitor.core.service.RoleService;
import com.monitor.core.service.UserService;
import com.monitor.core.utils.DateUtil;
import com.monitor.core.utils.Md5Util;

@RestController
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private OrganService organService;
	@Autowired
	private RoleService roleService;
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
		Page<User> page = new Page<>();
		Map<String, Object> values = rq.getQrq();
		values.put("_u_userStatus", Short.valueOf((String) values.getOrDefault("_u_userStatus", "1")));
		
		//String hql = rq.getHqlWithParam("select new map(u.userId as userId, i.infoId as infoId, u.userName as userName, i.nickName as nickName, u.userPhone as userPhone, u.userEmail as userEmail) from User u left join u.userInfo i", true);
		//mapService.getPageList(page, hql, values);
		String hql = rq.getHqlWithParam("select u from User u left join fetch u.userInfo left join fetch u.roles as roles left join fetch u.organs as organs", true);
		userService.getPageList(page, hql, values);
		PageModel pageModel = new PageModel(page);
		return pageModel;
	}
	/**
	 * 获取用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/user/get")
	public User get(Integer id){
		User user = userService.getUser(id);
		return user;
	}
	/**
	 * 新增，修改
	 * @param user
	 * @param info
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(path = "/user/form", method = RequestMethod.POST)
	@Validator
	public ResultModel form(@Valid User user, @Valid UserInfo info, String[] orgIds, BindingResult bindingResult){
		List<Organ> organs = organService.getOrgans(orgIds);
		
		if(user.getUserId() == null){
			info.setAddTime(DateUtil.getDateByTime());
			user.setUserStatus((short)1);
			user.setUserSalt(AuthConstant.DEFAULT_USER_SALT);
			user.setUserPwd(Md5Util.md5(AuthConstant.DEFAULT_USER_PWD + AuthConstant.DEFAULT_USER_SALT));
		}else {
			user.setRoles(userService.getRoles(user.getUserId()));
			info.setUpdateTime(DateUtil.getDateByTime());
		}
		user.setOrgans(new HashSet<>(organs));//设置机构
		user.createUpdateHql();
		ResultModel result = new ResultModel();
		userService.saveOrUpdate(user, info);
		return result;
	}
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/user/del")
	public ResultModel del(String ids) {
		if(StringUtils.isEmpty(ids))
			return new ResultModel("参数不能为空");
		String[] arr_ = ids.split(",");
		Integer[] arr = new Integer[arr_.length];
		for (int i = 0; i < arr_.length; i++)
			arr[i] = Integer.valueOf(arr_[i]);
		userService.delete(arr);
		return new ResultModel();
	}
	/**
	 * 获取当前用户或者目标用户的角色
	 * 以及当前用户的所有角色
	 * @return
	 */
	@RequestMapping("/user/roles")
	public ResultModel roles(Integer userId){
		//userId如果为空，则查询用户自己的角色
		//如果userId与当前登录用户相同，则。。。
		
		//获取当前用户所在部门的角色集合
		List<Role> roles = roleService.getRolesByDep("1");
		ResultModel result = new ResultModel();
		Map<String, Object> map = Maps.newHashMap();
		map.put("roles", roles);
		result.setData(map);
		return result;
	}
}

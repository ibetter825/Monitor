package com.monitor.core.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.monitor.core.bean.entity.Organ;
import com.monitor.core.bean.model.TreeModel;
import com.monitor.core.service.MapService;
import com.monitor.core.service.OrganService;

@RestController
public class OrganController extends BaseController {
	@Autowired
	private OrganService organService;
	@Autowired
	private MapService mapService;
	
	@RequestMapping("/org")
	public ModelAndView index() {
		return new ModelAndView(VIEW_CORE_PATH + "user/list");
	}
	
	/**
	 * 查询数据机构树形节点
	 * @param pager
	 * @param rq
	 * @return
	 */
	@RequestMapping("/org/tree")
	public List<TreeModel> tree() {
		String rootId = "1";
		List<Organ> list = organService.getSubOrgans(rootId);
		Organ organ = new Organ();
		organ.setOrgId(rootId);
		List<TreeModel> treeList = Organ.getTreeModel(list, null);
		return treeList;
	}
	
}

package com.monitor.data.web.controller;

import java.util.HashMap;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.common.collect.Maps;
import com.monitor.core.bean.model.ResultModel;
import com.monitor.core.web.controller.BaseController;
import com.monitor.data.bean.entity.Grid;
import com.monitor.data.bean.entity.GridCell;
import com.monitor.data.bean.entity.GridCellKey;
import com.monitor.data.service.GridCellService;
import com.monitor.data.service.GridService;

@Controller
public class GridCellController extends BaseController {
	@Autowired
	private GridService gridService;
	@Autowired
	private GridCellService gridCellService;
	
	@RequestMapping("/grid")
	@ResponseBody
	public ResultModel index() {
		ResultModel result = new ResultModel();
		Grid grid = this.gridService.getById(1);
		System.err.println(grid.getGridCells().size() + "----------长度");
		Set<GridCell> gridCells = grid.getGridCells();
		HashMap<String, Object> map = Maps.newHashMap();
		map.put("grid", grid);
		map.put("cells", gridCells);
		result.setData(map);
		return result;
	}
	
	@RequestMapping("/grid/cell")
	@ResponseBody
	public GridCell cell() {
		GridCell cell = this.gridCellService.getById(new GridCellKey(1, 0, 0));
		return cell;
	}
}

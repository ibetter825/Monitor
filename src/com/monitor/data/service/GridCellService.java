package com.monitor.data.service;

import com.monitor.data.bean.entity.GridCell;
import com.monitor.data.bean.entity.GridCellKey;

public interface GridCellService {
	public GridCell getById(GridCellKey gridCellKey);
}

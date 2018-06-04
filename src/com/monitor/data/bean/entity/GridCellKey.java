package com.monitor.data.bean.entity;

import java.io.Serializable;

public class GridCellKey implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer gridId;
	private Integer rowNo;
	private Integer colNo;
	
	public GridCellKey() {}

	public GridCellKey(Integer gridId, Integer rowNo, Integer colNo) {
		this.gridId = gridId;
		this.rowNo = rowNo;
		this.colNo = colNo;
	}

	public Integer getGridId() {
		return gridId;
	}

	public void setGridId(Integer gridId) {
		this.gridId = gridId;
	}

	public Integer getRowNo() {
		return rowNo;
	}

	public void setRowNo(Integer rowNo) {
		this.rowNo = rowNo;
	}

	public Integer getColNo() {
		return colNo;
	}

	public void setColNo(Integer colNo) {
		this.colNo = colNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colNo == null) ? 0 : colNo.hashCode());
		result = prime * result + ((gridId == null) ? 0 : gridId.hashCode());
		result = prime * result + ((rowNo == null) ? 0 : rowNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GridCellKey other = (GridCellKey) obj;
		if (colNo == null) {
			if (other.colNo != null)
				return false;
		} else if (!colNo.equals(other.colNo))
			return false;
		if (gridId == null) {
			if (other.gridId != null)
				return false;
		} else if (!gridId.equals(other.gridId))
			return false;
		if (rowNo == null) {
			if (other.rowNo != null)
				return false;
		} else if (!rowNo.equals(other.rowNo))
			return false;
		return true;
	}
	
}

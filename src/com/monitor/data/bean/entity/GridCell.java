package com.monitor.data.bean.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.monitor.core.bean.entity.BaseEntity;

@Entity
@Table(name = "D_GRID_CELL")
@IdClass(GridCellKey.class)//联合主键
public class GridCell extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer gridId;
	@Id
	private Integer rowNo;
	@Id
	private Integer colNo;
	private String kpiCode;
	private String cellValue;
	
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
	public String getKpiCode() {
		return kpiCode;
	}
	public void setKpiCode(String kpiCode) {
		this.kpiCode = kpiCode;
	}
	public String getCellValue() {
		return cellValue;
	}
	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}
}

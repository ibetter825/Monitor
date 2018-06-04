package com.monitor.data.bean.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;
import com.monitor.core.bean.entity.BaseEntity;

@Entity
@Table(name = "D_GRID")
public class Grid extends BaseEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String width;
	private String height;
	
	@OneToMany(targetEntity = GridCell.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "gridId", referencedColumnName = "id")
	@JsonIgnore//使用@ResponseBody时不用此注解，懒加载会失效
	private Set<GridCell> gridCells = Sets.newHashSet();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	public Set<GridCell> getGridCells() {
		return gridCells;
	}
	public void setGridCells(Set<GridCell> gridCells) {
		this.gridCells = gridCells;
	}
}

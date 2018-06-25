package com.monitor.core.bean.model;

import java.util.List;
import com.monitor.core.orm.Page;

/**
 * 前台分页数据结果
 * @author ibett
 *
 */
public class PageModel {
	private Long total;
	private Integer pageSize;
	private Integer pageNumber;
	private Long totalPages;
	private List<?> rows;
	private List<?> footer;
	
	public PageModel() {
		super();
	}
	
	public PageModel(Page<?> page) {
		super();
		this.total = page.getTotalCount();
		this.pageNumber = page.getPageNo();
		this.pageSize = page.getPageSize();
		this.totalPages = page.getTotalPages();
		this.rows = page.getResult();
	}

	public PageModel(Long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public PageModel(Long total, List<?> rows, List<?> footer) {
		super();
		this.total = total;
		this.rows = rows;
		this.footer = footer;
	}

	public Long getTotal() {
		return total;
	}

	public PageModel setTotal(Long total) {
		this.total = total;
		return this;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public PageModel setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public PageModel setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
		return this;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public PageModel setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
		return this;
	}

	public List<?> getRows() {
		return rows;
	}

	public PageModel setRows(List<?> rows) {
		this.rows = rows;
		return this;
	}

	public List<?> getFooter() {
		return footer;
	}

	public PageModel setFooter(List<?> footer) {
		this.footer = footer;
		return this;
	}
}

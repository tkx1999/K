package com.it.www.util;

import java.util.List;

public class Pager<T> {

	private Integer currPage; //当前页数

	private Integer  countSum;  //总记录数

	private Integer pageSum;  //总页数

	private Integer  pageUnit;  //分页单位

	private List<T> pageList;   //页面记录

	// 获取上一页
	public Integer previousPage() {
		if (this.currPage > 1) {
			return this.currPage - 1;
		}
		return 1;
	}

	//获取下一页
	public Integer nextPage() {
		if (this.currPage >= this.pageSum) {
			return this.currPage;
		}
		return this.currPage + 1;
	}
	public Pager(Integer currPage, Integer countSum, Integer pageSum, Integer pageUnit, List<T> pageList) {
		super();
		this.currPage = currPage;
		this.countSum = countSum;
		this.pageSum = pageSum;
		this.pageUnit = pageUnit;
		this.pageList = pageList;
	}

	public Pager() {
		super();
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getCountSum() {
		return countSum;
	}

	public void setCountSum(Integer countSum) {
		this.countSum = countSum;
	}

	public Integer getPageSum() {
		this.pageSum = (int) Math.ceil((double) this.countSum / this.pageUnit);
		if (this.pageSum == 0) {
			return 1;
		}
		return pageSum;
	}

	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}

	public Integer getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(Integer pageUnit) {
		this.pageUnit = pageUnit;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

}

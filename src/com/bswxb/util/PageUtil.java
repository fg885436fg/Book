package com.bswxb.util;

import java.util.List;

public class PageUtil {
	// 总条数
	private int count;

	// 总页数
	private int navCount;
	// 起始行
	private int startRow;
	// 每页显示条数
	private int pageRow = 15;
	// 当前页
	private int curPage;
	// 首页
	private int firstPage = 1;
	// 尾页
	private int lastPage;
	// 前一页
	private int prePage;
	// 后一页
	private int nextPage;
	// 起始导航
	private int startNav;
	// 结束导航
	private int endNav;

	// 开始索引
	private int fromIndex;
	// 结束索引
	private int toIndex;

	// 创建对象的时候 该对象的所有属性自动初始化好
	/**
	 * 
	 * @param count
	 *            数据的总条数 由数据库中查出
	 * @param curPage
	 *            当前页 由页面传入
	 */
	public PageUtil(int count, int curPage) {
		
		if(curPage<=0) {
			
			curPage=1;
		}
		
		
		
		this.count = count;
		
		this.navCount = this.count % this.pageRow > 0 ? this.count
				/ this.pageRow + 1 : this.count / this.pageRow;
		if(curPage>this.navCount) {
			
			curPage =this.navCount;
		}
		
		
		this.curPage = curPage;
		
		
		
		this.startRow = (this.curPage - 1) * this.pageRow;
		this.lastPage = this.navCount;
		this.prePage = this.curPage <= this.firstPage ? this.firstPage
				: this.curPage - 1;
		this.nextPage = this.curPage >= this.lastPage ? this.lastPage
				: this.curPage + 1;
		if (this.navCount < 10) {
			// 不足十页的情况
			this.startNav = this.firstPage;
			this.endNav = this.lastPage;
		} else {
			if (this.curPage <= 6) {
				// 靠近首页的情况
				this.startNav = this.firstPage;
				this.endNav = 10;
			} else if (this.curPage >= this.lastPage - 4) {
				// 靠近尾页的情况
				this.startNav = this.lastPage - 9;
				this.endNav = this.lastPage;
			} else {
				this.startNav = this.curPage - 5;
				this.endNav = this.curPage + 4;
			}
		}

		// 起始索引
		this.fromIndex = this.pageRow * (this.curPage - 1);

		// 结束索引
		this.toIndex = this.pageRow * this.curPage > this.count ? this.count : this.pageRow * this.curPage;

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getNavCount() {
		return navCount;
	}

	public void setNavCount(int navCount) {
		this.navCount = navCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getPageRow() {
		return pageRow;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getStartNav() {
		return startNav;
	}

	public void setStartNav(int startNav) {
		this.startNav = startNav;
	}

	public int getEndNav() {
		return endNav;
	}

	public void setEndNav(int endNav) {
		this.endNav = endNav;
	}

	public int getFromIndex() {
		return fromIndex;
	}

	public void setFromIndex(int fromIndex) {
		this.fromIndex = fromIndex;
	}

	public int getToIndex() {
		return toIndex;
	}

	public void setToIndex(int toIndex) {
		this.toIndex = toIndex;
	}

}

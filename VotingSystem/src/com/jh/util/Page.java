package com.jh.util;

/**  
 * 类名称： Page
 * 类描述： 封装分页所有信息
*/ 

public class Page {
	private int everyPage;				//每页显示记录数
	private int totalCount;				//总记录数
	private int totalPage;				//总页数
	private int currentPage;			//当前页
	private int beginIndex;				//查询起始页
	private boolean hasPrePage;			//是否有上一页
	private boolean hasNextPage;		//是否有下一页
	
	/**  
	 * 函数名： Page
	 * 函数功能：自定义构造方法，接收分页信息的所有参数，然后进行设置 
	*/ 
	public Page(int everyPage, int totalCount, int totalPage,
				int currentPage, int beginIndex, boolean hasPrePage,
				boolean hasNextPage) {
		this.everyPage = everyPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.beginIndex = beginIndex;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
	}

	public int getEveryPage() {
		return everyPage;
	}

	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
}

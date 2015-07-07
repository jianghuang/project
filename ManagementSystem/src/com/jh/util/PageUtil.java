package com.jh.util;

/**  
 * 类名称： PageUtil
 * 类描述： 分页辅助
*/ 

public class PageUtil {
	/**  
	 * 函数名： createPage(int everyPage, int totalCount, int currentPage)
	 * 函数功能：通过分页信息的三个参数，进行分页
	*/ 
	public static Page createPage(int everyPage, int totalCount, int currentPage) {
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage,
					beginIndex, hasPrePage, hasNextPage);
	}
	
	/**  
	 * 函数名：getEveryPage(int everyPage)
	 * 函数功能：获得每页显示记录数
	*/ 
	public static int getEveryPage(int everyPage) {
		return everyPage == 0?10:everyPage;
	}
	
	/**  
	 * 函数名：getCurentPage(int currentPage)
	 * 函数功能：获得当前页
	*/ 
	public static int getCurrentPage(int currentPage) {
		return currentPage == 0?10:currentPage;
	}
	
	/**  
	 * 函数名： getTotalPage(int everyPage, int totalCount)
	 * 函数功能：获得总页数
	*/ 
	public static int getTotalPage(int everyPage, int totalCount) {
		int totalPage = 0;
		if((totalCount != 0) && (totalCount % everyPage == 0)) {
			totalPage = totalCount/everyPage;
		} else {
			totalPage = totalCount/everyPage + 1;
		}
		return totalPage;
	}
	
	/**  
	 * 函数名： getBeginPage(int everyPage, int currentPage)
	 * 函数功能：获得起始位置
	*/ 
	public static int getBeginIndex(int everyPage, int currentPage) {
		return (currentPage - 1) * everyPage;
	}
	
	/**  
	 * 函数名：getHasPrePage(int currentPage)
	 * 函数功能：是否有上一页
	*/ 
	public static boolean getHasPrePage(int currentPage) {
		return (currentPage == 1)? false : true;
	}
	
	/**  
	 * 函数名：getHasNextPage(int totalPage, int currentPage)
	 * 函数功能：是否有下一页
	*/ 
	public static boolean getHasNextPage(int totalPage, int currentPage) {
		return (currentPage == totalPage) || (totalPage == 0) ? false : true;
	}
}

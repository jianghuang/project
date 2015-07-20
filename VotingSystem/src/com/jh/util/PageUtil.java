package com.jh.util;

/**  
 * �����ƣ� PageUtil
 * �������� ��ҳ����
*/ 

public class PageUtil {
	/**  
	 * �������� createPage(int everyPage, int totalCount, int currentPage)
	 * �������ܣ�ͨ����ҳ��Ϣ���������������з�ҳ
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
	 * ��������getEveryPage(int everyPage)
	 * �������ܣ����ÿҳ��ʾ��¼��
	*/ 
	public static int getEveryPage(int everyPage) {
		return everyPage == 0?10:everyPage;
	}
	
	/**  
	 * ��������getCurentPage(int currentPage)
	 * �������ܣ���õ�ǰҳ
	*/ 
	public static int getCurrentPage(int currentPage) {
		return currentPage == 0?10:currentPage;
	}
	
	/**  
	 * �������� getTotalPage(int everyPage, int totalCount)
	 * �������ܣ������ҳ��
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
	 * �������� getBeginPage(int everyPage, int currentPage)
	 * �������ܣ������ʼλ��
	*/ 
	public static int getBeginIndex(int everyPage, int currentPage) {
		return (currentPage - 1) * everyPage;
	}
	
	/**  
	 * ��������getHasPrePage(int currentPage)
	 * �������ܣ��Ƿ�����һҳ
	*/ 
	public static boolean getHasPrePage(int currentPage) {
		return (currentPage == 1)? false : true;
	}
	
	/**  
	 * ��������getHasNextPage(int totalPage, int currentPage)
	 * �������ܣ��Ƿ�����һҳ
	*/ 
	public static boolean getHasNextPage(int totalPage, int currentPage) {
		return (currentPage == totalPage) || (totalPage == 0) ? false : true;
	}
}

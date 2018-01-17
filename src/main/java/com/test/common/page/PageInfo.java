package com.test.common.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class PageInfo implements Serializable {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentPageNo;
		result = prime * result + pageSize;
		result = prime * result + (totalCount == null ? 0 : totalCount);
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
		PageInfo other = (PageInfo) obj;
		if (currentPageNo != other.currentPageNo)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if ((totalCount==null?0:totalCount.intValue()) != (other.totalCount==null?0:other.totalCount.intValue()))
			return false;
		return true;
	}

	private static final int FIRST_PAGE_NO = 1;
	private static final int DEFAULT_PAGE_SIZE = 20;
	private static final int DEFAULT_DISPLAY_NUM = 2;
	private static final int DEFAULT_DISPLAY_NUM_TOTAL = 5;

	private int pageSize = DEFAULT_PAGE_SIZE;	// 每页显示数
	private Integer currentPageNo = null; // 当前是第几页
	private Integer totalCount = null; // 总记录数
	private Integer totalPage = null;
	
	private Integer leftNum = DEFAULT_DISPLAY_NUM;	// 当前页左显示数
	private Integer rightNum = DEFAULT_DISPLAY_NUM;	// 当前页右显示数
	
	private Integer prevPageNo;	// 上一页
	private Integer nextPageNo;	// 下一页
	
	private List<Integer> prevList = new ArrayList<Integer>();
	private List<Integer> nextList = new ArrayList<Integer>();

	/**
	 * 构造方法，默认当前页为第一页.
	 */
	public PageInfo(int totalCount) {
		this(FIRST_PAGE_NO, totalCount);
	}
	
	/**
	 * 构造方法.
	 * 
	 * @param start
	 *            当前页位置
	 * @param totalSize
	 *            数据库中总记录条数
	 *            
	 */
	public PageInfo(int start, int totalCount) {
		this(start, totalCount, DEFAULT_PAGE_SIZE);
	}
	
	/**
	 * @param start
	 *            当前页位置
	 * @param totalCount
	 *            数据库中总记录条数
	 * @param pageSize
	 *            每页显示数
	 *            
	 */
	public PageInfo(int start, int totalCount, int pageSize) {
		this.currentPageNo = start;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.totalPage = getTotalPage();
		if(currentPageNo <= totalPage){
			if(currentPageNo <= DEFAULT_DISPLAY_NUM_TOTAL){
				leftNum = currentPageNo - 1;
				rightNum = (totalCount>DEFAULT_DISPLAY_NUM_TOTAL)?(DEFAULT_DISPLAY_NUM_TOTAL-currentPageNo):totalCount;
			}else{
				int mod = currentPageNo%DEFAULT_DISPLAY_NUM_TOTAL;
				if(mod%DEFAULT_DISPLAY_NUM_TOTAL==1){
					rightNum = DEFAULT_DISPLAY_NUM_TOTAL-1;
					leftNum = 0;
				}else{
					leftNum = mod - 1;
					rightNum = DEFAULT_DISPLAY_NUM_TOTAL - mod;
				}
			}
		}else{
			currentPageNo = 1;
			rightNum = DEFAULT_DISPLAY_NUM_TOTAL-1;
			leftNum = 0;
		}
		
		prevPageNo = (currentPageNo>1)?currentPageNo-1:1;
		nextPageNo = (currentPageNo<totalPage)?currentPageNo+1:totalPage;
		
		getPrevPages();
		getNextPages();
	}

	/**
	 * 获取分页脚本
	 * 
	 * @return
	 */
	public String makePage(String url, int CASE) {
		StringBuffer str = new StringBuffer("");
		int tostart = currentPageNo - CASE;
		int toend = currentPageNo + CASE;
		if (currentPageNo - CASE < 1) {
			toend = (currentPageNo + CASE) - (currentPageNo - CASE - 1);
		}
		if (currentPageNo + CASE > getTotalPage()) {
			tostart = (currentPageNo - CASE)
					- (currentPageNo + CASE - getTotalPage());
		}
		if (toend > getTotalPage())
			toend = getTotalPage();
		if (tostart < 1)
			tostart = 1;

		for (int i = 1; i <= getTotalPage(); i++) {
			if (i >= tostart && i <= toend) {
				if (i != currentPageNo) {
					str.append("<a href=\"");
					str.append(url);
					str.append(i);
					str.append("\">");
					str.append(i);
					str.append("</a>");
					str.append("&nbsp;&nbsp;");
				} else {
					str.append(i);
					str.append("&nbsp;&nbsp;");
				}
			}
		}
		return str.toString();
	}

	/**
	 * 取总记录数.
	 */
	public Integer getTotalCount() {
		return this.totalCount;
	}

	/**
	 * 取总页数.
	 */
	public int getTotalPage() {
		return pageSize > 0 ? (totalCount + pageSize - 1) / pageSize : 0;
	}

	/**
	 * 取每页数据容量.
	 */
	public int getPageSize() {
		return pageSize;
	}

	public boolean isFirstPage() {
		return this.getCurrentPageNo() == FIRST_PAGE_NO ? true : false;
	}

	/**
	 * 该页是否有下一页.
	 */
	public boolean hasNextPage() {
		return this.getCurrentPageNo() < getTotalPage() - 1;
	}

	/**
	 * 该页是否有上一页.
	 */
	public boolean hasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}

	public boolean isLastPage() {
		return this.getCurrentPageNo() == getTotalPage() ? true : false;
	}

	/**
	 * 返回当前页开始的第一个序号
	 */
	public int getCurrentPageStart() {
		return getPageSize() * (getCurrentPageNo() - 1);
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNO) {
		this.currentPageNo = currentPageNO;
	}
	
	/**
	 * 当前页的前DISPLAY_NUM条页
	 */
	public List<Integer> getPrevPages() {
		int _frontStart = 1;
		
		if (currentPageNo > leftNum) {
			_frontStart = currentPageNo - leftNum;
		}
		
		
		for (int i=_frontStart; i<currentPageNo; i++) {
			if(i<=totalPage){
				prevList.add(i);
			}
		}
		
		return prevList;
	}
	
	/**
	 * 当前页的后DISPLAY_NUM条页 
	 */
	public List<Integer> getNextPages() {
		int _endCount = rightNum;
		
		if (rightNum < totalCount && (currentPageNo + rightNum) < totalCount) {
			_endCount = currentPageNo+_endCount;
			for (int i=currentPageNo+1; i<=_endCount; i++) {
				if(i<=totalPage){
					nextList.add(i);
				}
		    }
		} 
		else{
			for (int i=currentPageNo+1; i<=totalCount; i++) {
				if(i<=totalPage){
					nextList.add(i);
				}
		    }
		}
		
		return nextList;
	}
	
	public void print(){
		System.out.println("=================================================");
		System.out.println("当前页currentPageNo: " + currentPageNo); // 当前页
		System.out.println("总记录数totalCount: " + totalCount); // 总记录数
		System.out.println("每页显示数pageSize: " + pageSize);	// 每页显示数
		System.out.println("总页数totalPage: " + totalPage);	// 总页数
		
		System.out.println("左显示数leftNum: " + leftNum);	// 当前页左显示数
		System.out.println("右显示数rightNum: " + rightNum);	// 当前页右显示数
		
		System.out.println("上一页prevPageNo: " + prevPageNo);	// 上一页
		System.out.println("下一页nextPageNo: " + nextPageNo);	// 下一页
		System.out.println();
		
		
		// 打印分页显示信息
		StringBuilder builder = new StringBuilder("prevList[" + prevList.size() + "]: ");
		for (int i=0; i<prevList.size(); i++) {
			builder.append(prevList.get(i) + " ");
		}
		System.out.println(builder.toString());
		
		int currentPage = getCurrentPageNo();
		System.out.println("currentPage: " + currentPage);
		
		builder = new StringBuilder("nextList[" + nextList.size() + "]: ");
		for (int i=0; i < nextList.size(); i++) {
			builder.append(nextList.get(i) + " ");
		}
		System.out.println(builder.toString());

		System.out.println("=================================================");
	}
	
	public List<Integer> getPrevList() {
		return prevList;
	}

	public void setPrevList(List<Integer> prevList) {
		this.prevList = prevList;
	}

	public List<Integer> getNextList() {
		return nextList;
	}

	public void setNextList(List<Integer> nextList) {
		this.nextList = nextList;
	}
	
	public Integer getPrevPageNo() {
		return prevPageNo;
	}

	public void setPrevPageNo(Integer prevPageNo) {
		this.prevPageNo = prevPageNo;
	}

	public Integer getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(Integer nextPageNo) {
		this.nextPageNo = nextPageNo;
	}
	
	public static void main(String[] args){
		PageInfo paging = new PageInfo(7, 1430);
		paging.print();
	}

}
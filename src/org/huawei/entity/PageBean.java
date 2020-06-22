package org.huawei.entity;

public class PageBean {
	/**
	 * ��ǰҳ
	 */
	private int pageNo = 1;
	/**
	 * ÿҳ����
	 */
	private int pageSize  = 10;
	/**
	 * ������
	 */
	private int totalCount;
	/**
	 * ��ҳ��
	 */
	private int totalPage;
	/**
	 * ��һҳ
	 */
	private int nextPage;
	/**
	 * ��һҳ
	 */
	private int prevPage;
	
	public int getPageNo() {
		return pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public int getTotalPage() {
		this.totalPage = (this.getTotalCount() - 1) / this.pageSize + 1;
		return totalPage;
	}
	public int getNextPage() {
		return this.nextPage = this.getPageNo() >= this.getTotalPage() ? this.getTotalPage() : this.pageNo+1;
	}
	public int getPrevPage() {
		return this.prevPage = this.getPageNo() <= 1 ? 1 : this.pageNo-1;
	}
	public void setPageNo(int pageNo) {
		if(this.pageNo >= this.getTotalPage()){
			this.pageNo = this.getTotalPage();
		}else{
			this.pageNo = pageNo;
		}
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	
	
}

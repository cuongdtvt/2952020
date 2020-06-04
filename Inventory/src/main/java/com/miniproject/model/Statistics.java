package com.miniproject.model;

import java.util.Date;

public class Statistics {

	
	private Date createDate;
	
	private Long qty;
	
	public Statistics() {}
	
	public Statistics(Date createDate, Long qty) {
		
		this.createDate = createDate;
		this.qty = qty;
	}
	
	
	public Statistics(long qty) {
		this.qty = qty;
	}

	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	
}

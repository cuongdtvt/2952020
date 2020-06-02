package com.miniproject.model;

import java.util.Date;

public class Export {
	


	private long id;

	private long productID;

	private long qty;

	private String description;
	
	private Date createDate;
	
	
	public Export() {
		
	}
	
	
	public Export(long id, long productID, long qty, String description, Date createDate) {
		
		this.id = id;
		this.productID = productID;
		this.qty = qty;
		this.description = description;
		this.createDate = createDate;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



}

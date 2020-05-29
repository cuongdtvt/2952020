package com.miniproject.model;

import java.util.Date;

public class Import {
	




	private long id;

	private long productID;
	
	private String productName;
	
	private long qty;

	private String description;
	
	private Date createDate;
	
	


	
	
	
	public Import() {
		
	}
	
	
	public Import(long id, long productID, long qty, String description, Date createDate) {
		
		this.id = id;
		this.productID = productID;
		this.qty = qty;
		this.description = description;
		this.createDate = createDate;
	}
	
	
	
	
	public Import(long id, long productID, String productName, long qty, String description, Date createDate) {
		this.id = id;
		this.productID = productID;
		this.productName = productName;
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

	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
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
	
	@Override
	public String toString() {
		return "Import [id=" + id + ", productID=" + productID + ", qty=" + qty + ", description=" + description
				+ ", createDate=" + createDate + "]";
	}


}

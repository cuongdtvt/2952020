package com.miniproject.model;

public class Invoice {
	
	private long id;

	private long productID;

	private boolean type;

	private long qty;

	public Invoice(long id, long productID, boolean type, long qty) {
		this.id = id; 
		this.productID = productID;
		this.type = type;
		this.qty = qty;
		
	}

	public Long getId() {
		return id;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}


	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}


}

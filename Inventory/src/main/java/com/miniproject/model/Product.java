package com.miniproject.model;

public class Product {

	private long id; 

	private long cateID;

	private String name;

	private String description;

	private long qty;

	private String imgUrl;


	public Product(long id, long cateId, String name, String description, long qty, String imgUrl) {
		this.id = id;
		this.cateID = cateId;
		this.name = name;
		this.description = description;
		this.qty = qty;
		this.imgUrl = imgUrl;
	}

//	public Product(String string, String string2, String string3, long long1, String string4) {
//		// TODO Auto-generated constructor stub
//	}

	public Long getId() {
		return id;
	}

	public long getCateID() {
		return cateID;
	}

	public void setCateID(long cateID) {
		this.cateID = cateID;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	
	

}

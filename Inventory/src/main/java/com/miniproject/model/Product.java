package com.miniproject.model;

public class Product {

	private long id; 

	private long cateID;
	
	private String cateName;
	
	private String name;

	private String description;

	private long qty;

	private String imageUrl;
	
//	@Lob
//	private byte[] photo;
//	
//	
//
//	public byte[] getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(byte[] photo) {
//		this.photo = photo;
//	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}


//	@Lob
//	private MultipartFile multipartFile;
//

//	public byte[] getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(byte[] photo) {
//		this.photo = photo;
//	}
//
//	@Lob
//	private byte[] photo;
	
//	@Lob
//	private MultipartFile multipartFile;

	
	
	
//	public Product(long id, long cateID, String name, String cateName, String description, long qty, String imageUrl) {
//		
//		this.id = id;
//		this.cateID = cateID;
//		this.name = name;
//		this.cateName = cateName;
//		this.description = description;
//		this.qty = qty;
//		this.imageUrl = imageUrl;
//	}

//	public Product(String string, String string2, String string3, long long1, String string4) {
//		// TODO Auto-generated constructor stub
//	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(long id, long cateID, String name, String description, long qty, String imageUrl) {
		this.id = id;
		this.cateID = cateID;
		this.name = name;
		this.description = description;
		this.qty = qty;
		this.imageUrl = imageUrl;
	}
	
	public Product(long id, long cateID, String name, String cateName, String description, long qty, String imageUrl) {

		this.id = id;
		this.cateID = cateID;
		this.name = name;
		this.cateName = cateName;
		
		this.description = description;
		this.qty = qty;
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public long getCateID() {
		return cateID;
	}

	public void setCateID(long cateID) {
		this.cateID = cateID;
	}
	
//	public String getCateName() {
//		return cateName;
//	}
//
//	public void setCateName(String cateName) {
//		this.cateName = cateName;
//	}
	

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

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

//	public MultipartFile getMultipartFile() {
//		return multipartFile;
//	}
//
//	public void setMultipartFile(MultipartFile multipartFile) {
//		this.multipartFile = multipartFile;
//	}
//	

}

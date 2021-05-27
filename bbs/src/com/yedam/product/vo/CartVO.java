package com.yedam.product.vo;

public class CartVO {

	private String userID;
	private String itemCode;
	private int qty;
	
	private String itemName;
	private String itemImage;
	private int price;
	private String itemDesc;
	private int likeIt;
	private String sale;
	private int salePrice;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public int getLikeIt() {
		return likeIt;
	}
	public void setLikeIt(int likeIt) {
		this.likeIt = likeIt;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return "CartVO [userID=" + userID + ", itemCode=" + itemCode + ", qty=" + qty + ", itemName=" + itemName
				+ ", itemImage=" + itemImage + ", price=" + price + ", itemDesc=" + itemDesc + ", likeIt=" + likeIt
				+ ", sale=" + sale + ", salePrice=" + salePrice + "]";
	}
	
}

package com.tcs.eas.rest.apis.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
public class ProductResponse {

    private int productId;
    private String productName;
    private String productDescription;
    private String brand;
    private String productCategory;
    private byte[] image;
    private int availableQuantity;
    private int minimumQuantity;
    private String currency;
    private String storeId;
    private Double price;
    private int productCategoryId;
    private int productReviewCnt;
    private Double productReviewStars;
    private ProductSpecification productSpecification;
    private String mfgDate;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public int getMinimumQuantity() {
		return minimumQuantity;
	}
	public void setMinimumQuantity(int minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public int getProductReviewCnt() {
		return productReviewCnt;
	}
	public void setProductReviewCnt(int productReviewCnt) {
		this.productReviewCnt = productReviewCnt;
	}
	public Double getProductReviewStars() {
		return productReviewStars;
	}
	public void setProductReviewStars(Double productReviewStars) {
		this.productReviewStars = productReviewStars;
	}
	public ProductSpecification getProductSpecification() {
		return productSpecification;
	}
	public void setProductSpecification(ProductSpecification productSpecification) {
		this.productSpecification = productSpecification;
	}
	public String getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}
    
    
    
}

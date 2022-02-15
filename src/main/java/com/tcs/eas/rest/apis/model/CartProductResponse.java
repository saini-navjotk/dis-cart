package com.tcs.eas.rest.apis.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel
@Data
@AllArgsConstructor
public class CartProductResponse {

    private Integer productId;
    private String productName;
    private int productQuantity;
    private int availableQuantity;
    private double productPrice;
    private int offerId;

    public CartProductResponse() {
    }

    public CartProductResponse(Integer productId, String productName, int productQuantity, int availableQuantity, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.availableQuantity = availableQuantity;
        this.productPrice = productPrice;
    }

    public CartProductResponse(int productId2, String productName2, int cartQuantity, int availableQuantity2,
			Double price, int offerId2) {
    	productId = productId2;
    	productName = productName2;
    	this.productQuantity = cartQuantity;
    	availableQuantity = availableQuantity2;
    	this.productPrice = price;
    	offerId = offerId2;
    	
	}

	public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
}

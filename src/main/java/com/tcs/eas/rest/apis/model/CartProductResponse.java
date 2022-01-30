package com.tcs.eas.rest.apis.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public class CartProductResponse {

    private Integer productId;
    private String productName;
    //    private String productImage;
    private int productQuantity;
    private int availableQuantity;
    private double productPrice;

    public CartProductResponse() {
    }

    public CartProductResponse(Integer productId, String productName, int productQuantity, int availableQuantity, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.availableQuantity = availableQuantity;
        this.productPrice = productPrice;
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
}

package com.tcs.eas.rest.apis.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentProduct {

    private int productId;
    private String productName;
    private int productQuantity;
    private int availableQuantity;
    private Double productPrice;
    private boolean isDeliveryAvailable;
    private String expectedDeliveryDate;
    private DeliveryType deliveryType;
    private Double deliveryCharge;
    private Double totalShipmentCharge;
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
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public boolean isDeliveryAvailable() {
		return isDeliveryAvailable;
	}
	public void setDeliveryAvailable(boolean isDeliveryAvailable) {
		this.isDeliveryAvailable = isDeliveryAvailable;
	}
	public String getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}
	public void setExpectedDeliveryDate(String expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	public DeliveryType getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}
	public Double getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(Double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public Double getTotalShipmentCharge() {
		return totalShipmentCharge;
	}
	public void setTotalShipmentCharge(Double totalShipmentCharge) {
		this.totalShipmentCharge = totalShipmentCharge;
	}

    /*private String productImage;*/
    
    
}

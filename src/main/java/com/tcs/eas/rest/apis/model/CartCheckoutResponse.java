package com.tcs.eas.rest.apis.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartCheckoutResponse {

    private int cartId;
    private int userId;
    private PaymentInfo paymentInfo;
    private UserInfo userInfo;
    private DeliveryInfo deliveryInfo;
    private List<ShipmentProduct> shipmentProducts;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public DeliveryInfo getDeliveryInfo() {
		return deliveryInfo;
	}
	public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}
	public List<ShipmentProduct> getShipmentProducts() {
		return shipmentProducts;
	}
	public void setShipmentProducts(List<ShipmentProduct> shipmentProducts) {
		this.shipmentProducts = shipmentProducts;
	}

    
    
}

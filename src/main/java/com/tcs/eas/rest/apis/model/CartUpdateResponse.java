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
public class CartUpdateResponse {
    private int cartId;
    private int userId;
    private String date;
    private int cartQuantity;
    private List<CartProductUpdateResponse> cartProductUpdateResponseList;
    private byte[] image;
    private String brand;
    private String status;
    
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public List<CartProductUpdateResponse> getCartProductUpdateResponseList() {
		return cartProductUpdateResponseList;
	}
	public void setCartProductUpdateResponseList(List<CartProductUpdateResponse> cartProductUpdateResponseList) {
		this.cartProductUpdateResponseList = cartProductUpdateResponseList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
    
    
}

package com.tcs.eas.rest.apis.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
public class CartProductRequest {

    private int productId;
    private int cartQuantity;
    private int offerId;
    
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
    
    
}

package com.tcs.eas.rest.apis.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.List;

@Data
@Component
public class CartResponse {

    private int cartId;
    private int userId;
    private String date;
    private List<CartProductResponse> cartProductResponses;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<CartProductResponse> getCartProductResponses() {
        return cartProductResponses;
    }

    public void setCartProductResponses(List<CartProductResponse> cartProductResponses) {
        this.cartProductResponses = cartProductResponses;
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
    
    

}

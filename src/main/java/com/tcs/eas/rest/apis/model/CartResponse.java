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
    private int cartQuantity;
    private String status;
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

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    

}

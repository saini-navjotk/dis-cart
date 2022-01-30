package com.tcs.eas.rest.apis.model;

import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel
public class CartUpdateRequest {

    @NotNull(message = "cart Id is missing")
    private int cartId;

    @NotNull(message = "user id is missing")
    private int userId;

    private List<CartProductRequest> cartProducts;

    private String date;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CartProductRequest> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProductRequest> cartProducts) {
        this.cartProducts = cartProducts;
    }

}

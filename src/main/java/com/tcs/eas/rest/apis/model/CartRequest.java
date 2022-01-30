package com.tcs.eas.rest.apis.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel
@Data
public class CartRequest {

    @NotNull(message = "user id is missing")
    private int userId;

    private List<CartProductRequest> cartProducts;

    private String date;

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

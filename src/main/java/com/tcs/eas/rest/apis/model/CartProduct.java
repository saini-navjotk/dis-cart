package com.tcs.eas.rest.apis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "cartproduct")
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartproductid")
    private int cartProductId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cartid", referencedColumnName = "cartid")
    @JsonIgnoreProperties("cartProducts")
    private Cart cart;

    @Column(name = "productid")
    private int productId;

    @Column(name = "offerid", nullable = true)
    private int offerId;

    @Column(name = "qty")
    private int cartQuantity;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "updatedby")
    private String updatedBy;

    @Column(name = "createtimestamp")
    private Date createTimestamp;

    @Column(name = "updatetimestamp")
    private Date updateTimestamp;

    @PrePersist
    private void setDeafults() {
        this.updateTimestamp = new Date();
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public int getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(int cartProductId) {
        this.cartProductId = cartProductId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }


}

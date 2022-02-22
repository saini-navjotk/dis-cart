package com.tcs.eas.rest.apis.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel
@Data
//@AllArgsConstructor
public class CartProductResponse {

    private Integer productId;
    private String productName;
    private int productQuantity;
    private int availableQuantity;
    private double productPrice;
    private int offerId;
    private String brand;
    private byte[] image;

    public CartProductResponse() {
    }

    /**
	 * @param productId
	 * @param productName
	 * @param productQuantity
	 * @param availableQuantity
	 * @param productPrice
	 * @param offerId
	 */
	public CartProductResponse(Integer productId, String productName, int productQuantity, int availableQuantity,
			double productPrice, int offerId, String brand, byte[] image) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.availableQuantity = availableQuantity;
		this.productPrice = productPrice;
		this.offerId = offerId;
		this.brand = brand;
		this.image = image;
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

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
    
	
    
}

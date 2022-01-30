package com.tcs.eas.rest.apis.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;

@ApiModel
public class UserAddressApiModel {

	@Nullable
	private int addressId;

	private String addressline1;

	private String addressline2;

	@NotNull(message = "city field is missing")
	private String city;

	@NotNull(message = "zipCode field is missing")
	@Size(min = 4, message = "minimum 4 characters are required for zipCode")
	private String zipCode;

	@NotNull(message = "state field is missing")
	private String state;

	@NotNull(message = "country field is missing")
	private String country;

	@NotNull(message = "addressType field is missing")
	@Size(min = 4, message = "minimum 4 characters are required for addresstype")
	private String addressType;

	private String defaultSelected;

	public UserAddressApiModel() {
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getDefaultSelected() {
		return defaultSelected;
	}

	public void setDefaultSelected(String defaultSelected) {
		this.defaultSelected = defaultSelected;
	}

	public UserAddressApiModel(int addressId, String addressline1, String addressline2, String city, String zipCode,
			String state, String country, String addressType, String defaultSelected) {
		this.addressId = addressId;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
		this.country = country;
		this.addressType = addressType;
		this.defaultSelected = defaultSelected;

	}

	/**
	 * @param addressline1
	 * @param addressline2
	 * @param city
	 * @param zipCode
	 * @param state
	 * @param country
	 * @param addressType
	 * @param defaultSelected
	 */
	public UserAddressApiModel(String addressline1, String addressline2,
			@NotNull(message = "city field is missing") @Size(min = 3, message = "minimum 3 characters are required for city") String city,
			@NotNull(message = "zipCode field is missing") @Size(min = 4, message = "minimum 4 characters are required for zipCode") String zipCode,
			@NotNull(message = "state field is missing") @Size(min = 4, message = "minimum 4 characters are required for state") String state,
			@NotNull(message = "country field is missing") @Size(min = 4, message = "minimum 4 characters are required for country") String country,
			@NotNull(message = "addressType field is missing") @Size(min = 4, message = "minimum 4 characters are required for addresstype") String addressType,
			String defaultSelected) {
		super();
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
		this.country = country;
		this.addressType = addressType;
		this.defaultSelected = defaultSelected;

	}

}

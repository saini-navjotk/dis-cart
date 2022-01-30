package com.tcs.eas.rest.apis.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public class UserResponse {

	private int userId;
	private String userName;
	private String userEmail;
	private String contactNumber;
	private UserAddressApiModel userAddress;
	/*
	 * @Lob private byte[] profilePicture;
	 */

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public UserAddressApiModel getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddressApiModel userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * @param userId
	 * @param userName
	 * @param userEmail
	 * @param contactNumber
	 * @param userAddress
	 */
	public UserResponse(int userId, String userName, String userEmail, String contactNumber, UserAddressApiModel userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.contactNumber = contactNumber;
		this.userAddress = userAddress;
	}

}

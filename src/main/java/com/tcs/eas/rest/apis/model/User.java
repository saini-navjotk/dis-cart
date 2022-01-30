package com.tcs.eas.rest.apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

//@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2258366193131928337L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userId;

    @Column(name = "firstname", unique = false)
    private String firstName;

    @Column(name = "lastname", unique = false)
    private String lastName;

    @NotNull(message = "user email field is missing**")
    @Size(min = 10, message = "minimum 10 characters are required for user email")
    @Column(unique = true, name = "email")
    private String userEmail;

    @Column(name = "phone", unique = true)
    private String mobileNumber;

    @Column(name = "password", unique = true)
    private String userPassword;

    @Column(name = "createdby", unique = false)
    private String createdBy;

    @Column(name = "updatedby", unique = false)
    private String updatedBy;

    @Column(name = "status", unique = false)
    private String userStatus;

    private Address address;

   /* @Lob
    private byte[] profilePicture;*/

    @Column(name = "createdtimestamp")
    private Date createdTimeStamp;

    @Column(name = "updatedtimestamp")
    private Date updatedTimeStamp;

    @PrePersist
    void createdAt() {
        this.createdTimeStamp = this.updatedTimeStamp = new Date();
    }

    public User(String firstName, String lastName, String userEmail, String mobileNumber, String userPassword, String createdBy, String updatedBy, String userStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.mobileNumber = mobileNumber;
        this.userPassword = userPassword;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.userStatus = userStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public Date getUpdatedTimeStamp() {
        return updatedTimeStamp;
    }

    public void setUpdatedTimeStamp(Date updatedTimeStamp) {
        this.updatedTimeStamp = updatedTimeStamp;
    }

}

package com.tcs.eas.rest.apis.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
public class Address implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6422181969008180452L;

    private int addressid;

    private User user;

    private String addressline1;

    private String addressline2;

    private String city;

    private String zipCode;

    private String state;

    private String country;

    private String addresstype;

    private String defaultSelected;

    private String latitude;

    private String longitude;

    private String createdby;

    private Date createTimestamp;

    private String updatedby;

    private Date updateTimestamp;

    @PrePersist
    void createdAt() {
        this.createTimestamp = this.updateTimestamp = new Date();
    }

    public Address() {
    }

    public Address(int addressid, String addressline1, String addressline2, String city, String zipCode, String state, String country, String addresstype, String defaultSelected) {
        this.addressid = addressid;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.addresstype = addresstype;
        this.defaultSelected = defaultSelected;
    }

    public Address(String addressline1, String addressline2, String city, String zipCode, String state, String country, String addresstype, String defaultSelected) {
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.addresstype = addresstype;
        this.defaultSelected = defaultSelected;
    }

    public Address(int addressid, int userid, String addressline1, String addressline2, String city, String zipCode, String state, String country, String addresstype, String defaultSelected, String latitude, String longitude, String createdby, Date createTimestamp, String updatedby, Date updateTimestamp) {
        this.addressid = addressid;
//        this.userid = userid;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.addresstype = addresstype;
        this.defaultSelected = defaultSelected;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdby = createdby;
        this.createTimestamp = createTimestamp;
        this.updatedby = updatedby;
        this.updateTimestamp = updateTimestamp;
    }

    public Address(String addressline1, String addressline2, String city, String zipCode,
                   String state, String country, String addresstype, String defaultSelected
            , String latitude, String longitude, String createdby,
                   String updatedby) {
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.addresstype = addresstype;
        this.defaultSelected = defaultSelected;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdby = createdby;
        this.updatedby = updatedby;
    }


    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(String addresstype) {
        this.addresstype = addresstype;
    }

    public String getDefaultSelected() {
        return defaultSelected;
    }

    public void setDefaultSelected(String defaultSelected) {
        this.defaultSelected = defaultSelected;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressid=" + addressid +
                /*", userid=" + userid +*/
                ", addressline1='" + addressline1 + '\'' +
                ", addressline2='" + addressline2 + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", addresstype='" + addresstype + '\'' +
                ", defaultSelected='" + defaultSelected + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", createdby='" + createdby + '\'' +
                ", createTimestamp=" + createTimestamp +
                ", updatedby='" + updatedby + '\'' +
                ", updateTimestamp=" + updateTimestamp +
                '}';
    }
}

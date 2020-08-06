package com.meng.spbnodependence.bean;

import java.io.Serializable;

/**
 * @Description
 * @Author ZuoHao
 * @Date 2020-08-05 20:05
 */
public class OfflineStoreResult implements Serializable {

    private int storeId;
    private int areaCode;
    private String city;
    private String storeName;
    private String address;
    private String businessHours;
    private String listPicURL;
    private String storePicURL;
    private String longitude;
    private String latitude;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getListPicURL() {
        return listPicURL;
    }

    public void setListPicURL(String listPicURL) {
        this.listPicURL = listPicURL;
    }

    public String getStorePicURL() {
        return storePicURL;
    }

    public void setStorePicURL(String storePicURL) {
        this.storePicURL = storePicURL;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }
}

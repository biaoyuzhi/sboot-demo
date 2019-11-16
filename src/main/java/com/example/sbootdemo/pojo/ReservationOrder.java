package com.example.sbootdemo.pojo;

import java.util.Date;

public class ReservationOrder {
    private Integer id;

    private String orderId;

    private String userName;

    private String userPhone;

    private String userAddress;

    private String saleStore;

    private String doorPanoramic;

    private String doorThickness;

    private String edgeLength;

    private String remark;

    private Boolean isDeleted;

    private Date visitDate;

    private Date createDate;

    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getSaleStore() {
        return saleStore;
    }

    public void setSaleStore(String saleStore) {
        this.saleStore = saleStore == null ? null : saleStore.trim();
    }

    public String getDoorPanoramic() {
        return doorPanoramic;
    }

    public void setDoorPanoramic(String doorPanoramic) {
        this.doorPanoramic = doorPanoramic == null ? null : doorPanoramic.trim();
    }

    public String getDoorThickness() {
        return doorThickness;
    }

    public void setDoorThickness(String doorThickness) {
        this.doorThickness = doorThickness == null ? null : doorThickness.trim();
    }

    public String getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(String edgeLength) {
        this.edgeLength = edgeLength == null ? null : edgeLength.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
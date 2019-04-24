package com.lee.gmall.bean;


public class OrderInfo {

  private long id;
  private String consignee;
  private double totalAmount;
  private String orderStatus;
  private long userId;
  private String paymentWay;
  private java.sql.Timestamp expectDeliveryTime;
  private String deliveryAddress;
  private String orderComment;
  private String outTradeNo;
  private String tradeBody;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp expireTime;
  private String wareStatus;
  private long parentOrderId;
  private String processStatus;
  private String trackingNo;
  private String consigneeTel;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getConsignee() {
    return consignee;
  }

  public void setConsignee(String consignee) {
    this.consignee = consignee;
  }


  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }


  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getPaymentWay() {
    return paymentWay;
  }

  public void setPaymentWay(String paymentWay) {
    this.paymentWay = paymentWay;
  }


  public java.sql.Timestamp getExpectDeliveryTime() {
    return expectDeliveryTime;
  }

  public void setExpectDeliveryTime(java.sql.Timestamp expectDeliveryTime) {
    this.expectDeliveryTime = expectDeliveryTime;
  }


  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }


  public String getOrderComment() {
    return orderComment;
  }

  public void setOrderComment(String orderComment) {
    this.orderComment = orderComment;
  }


  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }


  public String getTradeBody() {
    return tradeBody;
  }

  public void setTradeBody(String tradeBody) {
    this.tradeBody = tradeBody;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(java.sql.Timestamp expireTime) {
    this.expireTime = expireTime;
  }


  public String getWareStatus() {
    return wareStatus;
  }

  public void setWareStatus(String wareStatus) {
    this.wareStatus = wareStatus;
  }


  public long getParentOrderId() {
    return parentOrderId;
  }

  public void setParentOrderId(long parentOrderId) {
    this.parentOrderId = parentOrderId;
  }


  public String getProcessStatus() {
    return processStatus;
  }

  public void setProcessStatus(String processStatus) {
    this.processStatus = processStatus;
  }


  public String getTrackingNo() {
    return trackingNo;
  }

  public void setTrackingNo(String trackingNo) {
    this.trackingNo = trackingNo;
  }


  public String getConsigneeTel() {
    return consigneeTel;
  }

  public void setConsigneeTel(String consigneeTel) {
    this.consigneeTel = consigneeTel;
  }

}

package com.lee.gmall.bean;


public class PaymentInfo {

  private long id;
  private String outTradeNo;
  private String orderId;
  private String alipayTradeNo;
  private double totalAmount;
  private String subject;
  private String paymentStatus;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp confirmTime;
  private String callbackContent;
  private java.sql.Timestamp callbackTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getOutTradeNo() {
    return outTradeNo;
  }

  public void setOutTradeNo(String outTradeNo) {
    this.outTradeNo = outTradeNo;
  }


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }


  public String getAlipayTradeNo() {
    return alipayTradeNo;
  }

  public void setAlipayTradeNo(String alipayTradeNo) {
    this.alipayTradeNo = alipayTradeNo;
  }


  public double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }


  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }


  public String getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getConfirmTime() {
    return confirmTime;
  }

  public void setConfirmTime(java.sql.Timestamp confirmTime) {
    this.confirmTime = confirmTime;
  }


  public String getCallbackContent() {
    return callbackContent;
  }

  public void setCallbackContent(String callbackContent) {
    this.callbackContent = callbackContent;
  }


  public java.sql.Timestamp getCallbackTime() {
    return callbackTime;
  }

  public void setCallbackTime(java.sql.Timestamp callbackTime) {
    this.callbackTime = callbackTime;
  }

}

package com.lee.gmall.bean;

import com.lee.gmall.bean.enums.PaymentWay;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderInfo implements Serializable {

    @GeneratedValue(generator = "JDBC")//增加这个注解解决了通用Mapper的insert不返回主键的问题
    @Id
    private String id;
  private String consignee;
  private BigDecimal totalAmount;
  private String orderStatus;
  private String userId;
  private PaymentWay paymentWay;
  private Date expectDeliveryTime;
  private String deliveryAddress;
  private String orderComment;
  private String outTradeNo;
  private String tradeBody;
  private Date createTime;
  private Date expireTime;
  private String wareStatus;
  private String parentOrderId;
  private String processStatus;
  private String trackingNo;
  private String consigneeTel;

  @Transient
  List<OrderDetail> orderDetailList;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getConsignee() {
    return consignee;
  }

  public void setConsignee(String consignee) {
    this.consignee = consignee;
  }


  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }


  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public PaymentWay getPaymentWay() {
    return paymentWay;
  }

  public void setPaymentWay(PaymentWay paymentWay) {
    this.paymentWay = paymentWay;
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


  public String getWareStatus() {
    return wareStatus;
  }

  public void setWareStatus(String wareStatus) {
    this.wareStatus = wareStatus;
  }


  public String getParentOrderId() {
    return parentOrderId;
  }

  public void setParentOrderId(String parentOrderId) {
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

    public Date getExpectDeliveryTime() {
        return expectDeliveryTime;
    }

    public void setExpectDeliveryTime(Date expectDeliveryTime) {
        this.expectDeliveryTime = expectDeliveryTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public List<OrderDetail> getOrderDetailList() {
    return orderDetailList;
  }

  public void setOrderDetailList(List<OrderDetail> orderDetailList) {
    this.orderDetailList = orderDetailList;
  }
}

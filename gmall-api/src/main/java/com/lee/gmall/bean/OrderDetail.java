package com.lee.gmall.bean;

import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetail implements Serializable {

  private String id;
  private String orderId;
  private String skuId;
  private String skuName;
  private String imgFileName;
  private BigDecimal orderPrice;
  private Integer skuNums;
  private String logisticsId;
  private String imgUrl;
  private Integer skuNum;

  @Transient
  private String hasStock;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }


  public String getSkuId() {
    return skuId;
  }

  public void setSkuId(String skuId) {
    this.skuId = skuId;
  }


  public String getSkuName() {
    return skuName;
  }

  public void setSkuName(String skuName) {
    this.skuName = skuName;
  }


  public String getImgFileName() {
    return imgFileName;
  }

  public void setImgFileName(String imgFileName) {
    this.imgFileName = imgFileName;
  }


  public BigDecimal getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(BigDecimal orderPrice) {
    this.orderPrice = orderPrice;
  }


  public Integer getSkuNums() {
    return skuNums;
  }

  public void setSkuNums(Integer skuNums) {
    this.skuNums = skuNums;
  }


  public String getLogisticsId() {
    return logisticsId;
  }

  public void setLogisticsId(String logisticsId) {
    this.logisticsId = logisticsId;
  }


  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }


  public Integer getSkuNum() {
    return skuNum;
  }

  public void setSkuNum(Integer skuNum) {
    this.skuNum = skuNum;
  }

  public String getHasStock() {
    return hasStock;
  }

  public void setHasStock(String hasStock) {
    this.hasStock = hasStock;
  }
}

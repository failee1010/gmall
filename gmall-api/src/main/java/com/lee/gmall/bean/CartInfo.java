package com.lee.gmall.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartInfo implements Serializable {

  private String id;
  private String userId;
  private String skuId;
  private BigDecimal cartPrice;
  private long quantity;
  private String imgUrl;
  private String isChecked;
  private BigDecimal skuPrice;
  private Integer skuNum;
  private String skuName;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getSkuId() {
    return skuId;
  }

  public void setSkuId(String skuId) {
    this.skuId = skuId;
  }


  public BigDecimal getCartPrice() {
    return cartPrice;
  }

  public void setCartPrice(BigDecimal cartPrice) {
    this.cartPrice = cartPrice;
  }


  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }


  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }


  public String getIsChecked() {
    return isChecked;
  }

  public void setIsChecked(String isChecked) {
    this.isChecked = isChecked;
  }


  public BigDecimal getSkuPrice() {
    return skuPrice;
  }

  public void setSkuPrice(BigDecimal skuPrice) {
    this.skuPrice = skuPrice;
  }


  public Integer getSkuNum() {
    return skuNum;
  }

  public void setSkuNum(Integer skuNum) {
    this.skuNum = skuNum;
  }


  public String getSkuName() {
    return skuName;
  }

  public void setSkuName(String skuName) {
    this.skuName = skuName;
  }

}

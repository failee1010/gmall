package com.lee.gmall.bean;

import java.io.Serializable;

public class SkuSaleAttrValue implements Serializable {

  private String id;
  private String skuId;
  private String saleAttrId;
  private String saleAttrValueId;
  private String saleAttrName;
  private String saleAttrValueName;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getSkuId() {
    return skuId;
  }

  public void setSkuId(String skuId) {
    this.skuId = skuId;
  }


  public String getSaleAttrId() {
    return saleAttrId;
  }

  public void setSaleAttrId(String saleAttrId) {
    this.saleAttrId = saleAttrId;
  }


  public String getSaleAttrValueId() {
    return saleAttrValueId;
  }

  public void setSaleAttrValueId(String saleAttrValueId) {
    this.saleAttrValueId = saleAttrValueId;
  }


  public String getSaleAttrName() {
    return saleAttrName;
  }

  public void setSaleAttrName(String saleAttrName) {
    this.saleAttrName = saleAttrName;
  }


  public String getSaleAttrValueName() {
    return saleAttrValueName;
  }

  public void setSaleAttrValueName(String saleAttrValueName) {
    this.saleAttrValueName = saleAttrValueName;
  }

}

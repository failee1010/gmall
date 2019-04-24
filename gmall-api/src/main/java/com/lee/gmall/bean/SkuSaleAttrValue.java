package com.lee.gmall.bean;

public class SkuSaleAttrValue {

  private long id;
  private long skuId;
  private long saleAttrId;
  private long saleAttrValueId;
  private String saleAttrName;
  private String saleAttrValueName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getSkuId() {
    return skuId;
  }

  public void setSkuId(long skuId) {
    this.skuId = skuId;
  }


  public long getSaleAttrId() {
    return saleAttrId;
  }

  public void setSaleAttrId(long saleAttrId) {
    this.saleAttrId = saleAttrId;
  }


  public long getSaleAttrValueId() {
    return saleAttrValueId;
  }

  public void setSaleAttrValueId(long saleAttrValueId) {
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

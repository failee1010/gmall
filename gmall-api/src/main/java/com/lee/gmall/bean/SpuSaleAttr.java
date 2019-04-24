package com.lee.gmall.bean;


public class SpuSaleAttr {

  private long id;
  private long spuId;
  private long saleAttrId;
  private String saleAttrName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getSpuId() {
    return spuId;
  }

  public void setSpuId(long spuId) {
    this.spuId = spuId;
  }


  public long getSaleAttrId() {
    return saleAttrId;
  }

  public void setSaleAttrId(long saleAttrId) {
    this.saleAttrId = saleAttrId;
  }


  public String getSaleAttrName() {
    return saleAttrName;
  }

  public void setSaleAttrName(String saleAttrName) {
    this.saleAttrName = saleAttrName;
  }

}

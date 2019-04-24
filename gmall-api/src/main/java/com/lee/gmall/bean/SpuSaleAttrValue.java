package com.lee.gmall.bean;


public class SpuSaleAttrValue {

  private long id;
  private long spuId;
  private long saleAttrId;
  private String saleAttrValueName;


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


  public String getSaleAttrValueName() {
    return saleAttrValueName;
  }

  public void setSaleAttrValueName(String saleAttrValueName) {
    this.saleAttrValueName = saleAttrValueName;
  }

}

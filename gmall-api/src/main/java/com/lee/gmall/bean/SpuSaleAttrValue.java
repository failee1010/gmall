package com.lee.gmall.bean;

import java.io.Serializable;

public class SpuSaleAttrValue implements Serializable {

  private String id;
  private String spuId;
  private String saleAttrId;
  private String saleAttrValueName;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getSpuId() {
    return spuId;
  }

  public void setSpuId(String spuId) {
    this.spuId = spuId;
  }


  public String getSaleAttrId() {
    return saleAttrId;
  }

  public void setSaleAttrId(String saleAttrId) {
    this.saleAttrId = saleAttrId;
  }


  public String getSaleAttrValueName() {
    return saleAttrValueName;
  }

  public void setSaleAttrValueName(String saleAttrValueName) {
    this.saleAttrValueName = saleAttrValueName;
  }

}

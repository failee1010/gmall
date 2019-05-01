package com.lee.gmall.bean;

import java.io.Serializable;

public class SkuAttrValue implements Serializable {

  private String id;
  private String attrId;
  private String valueId;
  private String skuId;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getAttrId() {
    return attrId;
  }

  public void setAttrId(String attrId) {
    this.attrId = attrId;
  }


  public String getValueId() {
    return valueId;
  }

  public void setValueId(String valueId) {
    this.valueId = valueId;
  }


  public String getSkuId() {
    return skuId;
  }

  public void setSkuId(String skuId) {
    this.skuId = skuId;
  }

}

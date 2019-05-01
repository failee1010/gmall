package com.lee.gmall.bean;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SpuSaleAttr implements Serializable {

  private String id;
  private String spuId;
  private String saleAttrId;
  private String saleAttrName;

  @Transient
  private List<SpuSaleAttrValue> spuSaleAttrValueList;

  @Transient
  private Map<String, String> spuSaleAttrValueJson;

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


  public String getSaleAttrName() {
    return saleAttrName;
  }

  public List<SpuSaleAttrValue> getSpuSaleAttrValueList() {
    return spuSaleAttrValueList;
  }

  public void setSpuSaleAttrValueList(List<SpuSaleAttrValue> spuSaleAttrValueList) {
    this.spuSaleAttrValueList = spuSaleAttrValueList;
  }

  public Map<String, String> getSpuSaleAttrValueJson() {
    return spuSaleAttrValueJson;
  }

  public void setSpuSaleAttrValueJson(Map<String, String> spuSaleAttrValueJson) {
    this.spuSaleAttrValueJson = spuSaleAttrValueJson;
  }

  public void setSaleAttrName(String saleAttrName) {

    this.saleAttrName = saleAttrName;
  }

}

package com.lee.gmall.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

public class SpuInfo implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")//增加这个注解解决了通用Mapper的insert不返回主键的问题
  private String id;
  private String spuName;
  private String description;
  private String catalog3Id;
  private String tmId;

  @Transient
  private List<SpuSaleAttr> spuSaleAttrList;
  @Transient
  private List<SpuImage> spuImageList;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getSpuName() {
    return spuName;
  }

  public void setSpuName(String spuName) {
    this.spuName = spuName;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getCatalog3Id() {
    return catalog3Id;
  }

  public void setCatalog3Id(String catalog3Id) {
    this.catalog3Id = catalog3Id;
  }


  public String getTmId() {
    return tmId;
  }

  public void setTmId(String tmId) {
    this.tmId = tmId;
  }

  public List<SpuSaleAttr> getSpuSaleAttrList() {
        return spuSaleAttrList;
  }

  public void setSpuSaleAttrList(List<SpuSaleAttr> spuSaleAttrList) {
        this.spuSaleAttrList = spuSaleAttrList;
    }

    public List<SpuImage> getSpuImageList() {

        return spuImageList;
    }

    public void setSpuImageList(List<SpuImage> spuImageList) {
        this.spuImageList = spuImageList;
    }
}

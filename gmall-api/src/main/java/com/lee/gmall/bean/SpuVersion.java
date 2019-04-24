package com.lee.gmall.bean;


public class SpuVersion {

  private long id;
  private long spuId;
  private String spuVersion;
  private String isEnabled;


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


  public String getSpuVersion() {
    return spuVersion;
  }

  public void setSpuVersion(String spuVersion) {
    this.spuVersion = spuVersion;
  }


  public String getIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(String isEnabled) {
    this.isEnabled = isEnabled;
  }

}

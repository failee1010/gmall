package com.lee.gmall.bean;


public class BaseTrademark {

  private long id;
  private String tmName;
  private String logoUrl;
  private String isEnable;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTmName() {
    return tmName;
  }

  public void setTmName(String tmName) {
    this.tmName = tmName;
  }


  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }


  public String getIsEnable() {
    return isEnable;
  }

  public void setIsEnable(String isEnable) {
    this.isEnable = isEnable;
  }

}

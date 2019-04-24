package com.lee.gmall.bean;

import java.io.Serializable;

public class BaseAttrValue implements Serializable {

  private String id;
  private String valueName;
  private String attrId;
  private String isEnabled;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getValueName() {
    return valueName;
  }

  public void setValueName(String valueName) {
    this.valueName = valueName;
  }


  public String getAttrId() {
    return attrId;
  }

  public void setAttrId(String attrId) {
    this.attrId = attrId;
  }


  public String getIsEnabled() {
    return isEnabled;
  }

  public void setIsEnabled(String isEnabled) {
    this.isEnabled = isEnabled;
  }

}

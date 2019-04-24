package com.lee.gmall.bean;

import java.io.Serializable;

public class BaseCatalog1 implements Serializable {

  private String id;
  private String name;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}

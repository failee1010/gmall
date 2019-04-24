package com.lee.gmall.bean;


public class WareOrderTaskDetail {

  private long id;
  private long skuId;
  private String skuName;
  private long skuNums;
  private long taskId;
  private long skuNum;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getSkuId() {
    return skuId;
  }

  public void setSkuId(long skuId) {
    this.skuId = skuId;
  }


  public String getSkuName() {
    return skuName;
  }

  public void setSkuName(String skuName) {
    this.skuName = skuName;
  }


  public long getSkuNums() {
    return skuNums;
  }

  public void setSkuNums(long skuNums) {
    this.skuNums = skuNums;
  }


  public long getTaskId() {
    return taskId;
  }

  public void setTaskId(long taskId) {
    this.taskId = taskId;
  }


  public long getSkuNum() {
    return skuNum;
  }

  public void setSkuNum(long skuNum) {
    this.skuNum = skuNum;
  }

}

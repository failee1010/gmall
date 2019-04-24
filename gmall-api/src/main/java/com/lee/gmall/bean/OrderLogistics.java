package com.lee.gmall.bean;


public class OrderLogistics {

  private long id;
  private long orderId;
  private String logisticsStatus;
  private String logisticsNo;
  private java.sql.Timestamp createTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public String getLogisticsStatus() {
    return logisticsStatus;
  }

  public void setLogisticsStatus(String logisticsStatus) {
    this.logisticsStatus = logisticsStatus;
  }


  public String getLogisticsNo() {
    return logisticsNo;
  }

  public void setLogisticsNo(String logisticsNo) {
    this.logisticsNo = logisticsNo;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

}

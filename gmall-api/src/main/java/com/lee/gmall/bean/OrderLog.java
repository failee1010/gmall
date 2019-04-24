package com.lee.gmall.bean;


public class OrderLog {

  private long id;
  private long orderId;
  private java.sql.Timestamp operateDate;
  private String logComment;


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


  public java.sql.Timestamp getOperateDate() {
    return operateDate;
  }

  public void setOperateDate(java.sql.Timestamp operateDate) {
    this.operateDate = operateDate;
  }


  public String getLogComment() {
    return logComment;
  }

  public void setLogComment(String logComment) {
    this.logComment = logComment;
  }

}

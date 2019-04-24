package com.lee.gmall.bean;


public class WareSku {

  private long id;
  private long skuId;
  private long warehouseId;
  private long stock;
  private String stockName;
  private long stockLocked;


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


  public long getWarehouseId() {
    return warehouseId;
  }

  public void setWarehouseId(long warehouseId) {
    this.warehouseId = warehouseId;
  }


  public long getStock() {
    return stock;
  }

  public void setStock(long stock) {
    this.stock = stock;
  }


  public String getStockName() {
    return stockName;
  }

  public void setStockName(String stockName) {
    this.stockName = stockName;
  }


  public long getStockLocked() {
    return stockLocked;
  }

  public void setStockLocked(long stockLocked) {
    this.stockLocked = stockLocked;
  }

}

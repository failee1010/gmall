package com.lee.gmall.service;

import com.lee.gmall.bean.SkuInfo;

import java.math.BigDecimal;
import java.util.List;

public interface SkuService {

    List<SkuInfo> getSkuListBySpuId(String spuId);

    void saveSku(SkuInfo skuInfo);

    SkuInfo getSkuById(String skuId);

    List<SkuInfo> getSkuListByCatalog3Id(String catalog3Id);

    boolean checkPrice(BigDecimal skuPrice, String skuId);
}

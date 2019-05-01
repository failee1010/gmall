package com.lee.gmall.service;

import com.lee.gmall.bean.SkuInfo;

import java.util.List;

public interface SkuService {

    List<SkuInfo> getSkuListBySpuId(String spuId);

    void saveSku(SkuInfo skuInfo);
}

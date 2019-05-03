package com.lee.gmall.service;

import com.lee.gmall.bean.*;

import java.util.List;
import java.util.Map;

public interface SpuService {
    List<SpuInfo> spuList(String catalog3Id);

    List<BaseSaleAttr> baseSaleAttrList();

    void saveSpu(SpuInfo spuInfo);

    List<SpuImage> getSpuImageList(String spuId);

    List<SpuSaleAttr> getSpuSaleAttrList(String spuId);

    void deleteSpu(String spuId);

    List<SpuSaleAttr> getSpuSaleAttrListBySpuId(String spuId);

    List<SpuSaleAttr> getSpuSaleAttrListCheckBySku(Map<String, String> idMap);

    List<SkuInfo> getSkuSaleAttrValueListBySpu(String spuId);
}

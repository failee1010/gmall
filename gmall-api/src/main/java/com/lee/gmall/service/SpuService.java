package com.lee.gmall.service;

import com.lee.gmall.bean.BaseSaleAttr;
import com.lee.gmall.bean.SpuImage;
import com.lee.gmall.bean.SpuInfo;
import com.lee.gmall.bean.SpuSaleAttr;

import java.util.List;

public interface SpuService {
    List<SpuInfo> spuList(String catalog3Id);

    List<BaseSaleAttr> baseSaleAttrList();

    void saveSpu(SpuInfo spuInfo);

    List<SpuImage> getSpuImageList(String spuId);

    List<SpuSaleAttr> getSpuSaleAttrList(String spuId);

    void deleteSpu(String spuId);

    List<SpuSaleAttr> getSpuSaleAttrListBySpuId(String spuId);
}

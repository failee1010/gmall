package com.lee.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lee.gmall.bean.SkuAttrValue;
import com.lee.gmall.bean.SkuImage;
import com.lee.gmall.bean.SkuInfo;
import com.lee.gmall.bean.SkuSaleAttrValue;
import com.lee.gmall.manage.mapper.SkuAttrValueMapper;
import com.lee.gmall.manage.mapper.SkuImageMapper;
import com.lee.gmall.manage.mapper.SkuInfoMapper;
import com.lee.gmall.manage.mapper.SkuSaleAttrValueMapper;
import com.lee.gmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    SkuInfoMapper skuInfoMapper;
    @Autowired
    SkuAttrValueMapper skuAttrValueMapper;
    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper;
    @Autowired
    SkuImageMapper skuImageMapper;

    @Override
    public List<SkuInfo> getSkuListBySpuId(String spuId) {
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setSpuId(spuId);
        return skuInfoMapper.select(skuInfo);
    }

    @Override
    public void saveSku(SkuInfo skuInfo) {
        skuInfoMapper.insert(skuInfo);
        String skuId = skuInfo.getId();

        List<SkuAttrValue> skuAttrValueList = skuInfo.getSkuAttrValueList();
        for (SkuAttrValue skuAttrValue :
                skuAttrValueList) {
            skuAttrValue.setSkuId(skuId);
            skuAttrValueMapper.insert(skuAttrValue);
        }

        List<SkuSaleAttrValue> skuSaleAttrValueList = skuInfo.getSkuSaleAttrValueList();
        for (SkuSaleAttrValue skuSaleAttrValue :
                skuSaleAttrValueList) {
            skuSaleAttrValue.setSkuId(skuId);
            skuSaleAttrValueMapper.insert(skuSaleAttrValue);
        }

        List<SkuImage> skuImageList = skuInfo.getSkuImageList();
        for (SkuImage skuImage :
                skuImageList) {
            skuImage.setSkuId(skuId);
            skuImageMapper.insert(skuImage);
        }

    }
}

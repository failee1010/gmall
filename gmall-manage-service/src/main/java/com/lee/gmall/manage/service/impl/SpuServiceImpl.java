package com.lee.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lee.gmall.bean.*;
import com.lee.gmall.manage.mapper.*;
import com.lee.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    SpuInfoMapper spuInfoMapper;
    @Autowired
    BaseSaleAttrMapper baseSaleAttrMapper;
    @Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;
    @Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;
    @Autowired
    SpuImageMapper spuImageMapper;


    @Override
    public List<SpuInfo> spuList(String catalog3Id) {
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
        List<SpuInfo> spuInfos = spuInfoMapper.select(spuInfo);
        return spuInfos;
    }

    @Override
    public List<BaseSaleAttr> baseSaleAttrList() {
        List<BaseSaleAttr> baseSaleAttrs = baseSaleAttrMapper.selectAll();
        return baseSaleAttrs;
    }

    @Override
    public void saveSpu(SpuInfo spuInfo) {
        //保存SpuInfo
        spuInfoMapper.insertSelective(spuInfo);
        String spuId = spuInfo.getId();
        //保存SPU图片信息
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        for (SpuImage spuImage :
                spuImageList) {
            spuImage.setSpuId(spuId);
            spuImageMapper.insert(spuImage);
        }
        //保存SPU销售属性
        SpuSaleAttr spuSaleAttr = new SpuSaleAttr();
        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        for (SpuSaleAttr saleAttr:
             spuSaleAttrList) {
            saleAttr.setSpuId(spuId);
            spuSaleAttrMapper.insert(saleAttr);
            //保存SPU销售属性值
            List<SpuSaleAttrValue> spuSaleAttrValueList = saleAttr.getSpuSaleAttrValueList();
            for (SpuSaleAttrValue attrValue :
                    spuSaleAttrValueList) {
                attrValue.setSpuId(spuId);
                spuSaleAttrValueMapper.insert(attrValue);
            }
        }

    }

    @Override
    public List<SpuImage> getSpuImageList(String spuId) {
        SpuImage spuImage = new SpuImage();
        spuImage.setSpuId(spuId);
        List<SpuImage> select = spuImageMapper.select(spuImage);

        return select;


    }

    @Override
    public List<SpuSaleAttr> getSpuSaleAttrList(String spuId) {
        SpuSaleAttr saleAttr = new SpuSaleAttr();
        saleAttr.setSpuId(spuId);
        return spuSaleAttrMapper.select(saleAttr);
    }

    @Override
    public void deleteSpu(String spuId) {
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setId(spuId);
        spuInfoMapper.delete(spuInfo);
        SpuImage spuImage = new SpuImage();
        spuImage.setSpuId(spuId);
        spuImageMapper.delete(spuImage);
        SpuSaleAttr saleAttr = new SpuSaleAttr();
        saleAttr.setSpuId(spuId);
        spuSaleAttrMapper.delete(saleAttr);
        SpuSaleAttrValue spuSaleAttrValue = new SpuSaleAttrValue();
        spuSaleAttrValue.setSpuId(spuId);
        spuSaleAttrValueMapper.delete(spuSaleAttrValue);
    }

    @Override
    public List<SpuSaleAttr> getSpuSaleAttrListBySpuId(String spuId) {
        SpuSaleAttr saleAttr = new SpuSaleAttr();
        saleAttr.setSpuId(spuId);
        List<SpuSaleAttr> spuSaleAttrs = spuSaleAttrMapper.select(saleAttr);
        for (SpuSaleAttr spuSaleAttr :
                spuSaleAttrs) {
            SpuSaleAttrValue spuSaleAttrValue = new SpuSaleAttrValue();
            spuSaleAttrValue.setSaleAttrId(spuSaleAttr.getSaleAttrId());
            spuSaleAttrValue.setSpuId(spuId);
            List<SpuSaleAttrValue> spuSaleAttrValues = spuSaleAttrValueMapper.select(spuSaleAttrValue);
            spuSaleAttr.setSpuSaleAttrValueList(spuSaleAttrValues);
        }
        return spuSaleAttrs;
    }

    @Override
    public List<SpuSaleAttr> getSpuSaleAttrListCheckBySku(Map<String, String> idMap) {

        return spuSaleAttrValueMapper.selectSpuSaleAttrListCheckBySku(idMap);
    }

    @Override
    public List<SkuInfo> getSkuSaleAttrValueListBySpu(String spuId) {
        return spuSaleAttrValueMapper.selectSkuSaleAttrValueListBySpu(spuId);
    }

}

package com.lee.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lee.gmall.bean.SkuAttrValue;
import com.lee.gmall.bean.SkuImage;
import com.lee.gmall.bean.SkuInfo;
import com.lee.gmall.bean.SkuSaleAttrValue;
import com.lee.gmall.manage.mapper.SkuAttrValueMapper;
import com.lee.gmall.manage.mapper.SkuImageMapper;
import com.lee.gmall.manage.mapper.SkuInfoMapper;
import com.lee.gmall.manage.mapper.SkuSaleAttrValueMapper;
import com.lee.gmall.service.SkuService;
import com.lee.gmall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

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
    @Autowired
    RedisUtil redisUtil;

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

    @Override
    public SkuInfo getSkuById(String skuId) {

        Jedis jedis = redisUtil.getJedis();
        SkuInfo skuInfo = new SkuInfo();

        //查询redis缓存
        String key = "sku:" + skuId + ":info";
        String val = jedis.get(key);
        skuInfo = JSON.parseObject(val, SkuInfo.class);

        if (skuInfo == null) {
            //查询数db
             skuInfo = getSkuByIdFormDb(skuId);
            //同步缓存
            jedis.set(key, JSON.toJSONString(skuInfo));
        }
        return skuInfo;
    }

    private SkuInfo getSkuByIdFormDb(String skuId) {
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setId(skuId);
        SkuInfo sku = skuInfoMapper.selectOne(skuInfo);

        SkuImage skuImage = new SkuImage();
        skuImage.setSkuId(skuId);
        List<SkuImage> skuImages = skuImageMapper.select(skuImage);
        sku.setSkuImageList(skuImages);

        SkuSaleAttrValue skuSaleAttrValue = new SkuSaleAttrValue();
        skuSaleAttrValue.setSkuId(skuId);
        List<SkuSaleAttrValue> skuSaleAttrValues = skuSaleAttrValueMapper.select(skuSaleAttrValue);
        sku.setSkuSaleAttrValueList(skuSaleAttrValues);
        return sku;
    }
}

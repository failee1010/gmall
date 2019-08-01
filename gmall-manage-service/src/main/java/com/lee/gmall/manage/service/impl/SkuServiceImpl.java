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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
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
        //redis缓存和缓存锁应该为不同的节点，这里简化为在同一个节点上

        Jedis jedis = redisUtil.getJedis();
        SkuInfo skuInfo = null;

        //查询redis缓存
        String key = "sku:" + skuId + ":info";
        String val = jedis.get(key);
        //此数据在数据库中也没有，直接返回空值
        if ("empty".equals(val)) {
            return skuInfo;
        }

        if (StringUtils.isBlank(val)) {//没有命中缓存，查询数据库

            //申请缓存锁
            String OK = jedis.set("sku:" + skuId + ":lock", "1", "nx", "px", 3000);

            if ("OK".equals(OK)) {//拿到缓存锁
                //查询数db
                skuInfo = getSkuByIdFormDb(skuId);

                if (skuInfo != null) {
                    //同步缓存
                    jedis.set(key, JSON.toJSONString(skuInfo));
                } else {
                    //通知同伴
                    jedis.setex("sku:" + skuId + ":info", 10, "empty");
                }
                //归还锁
                jedis.del("sku:" + skuId + ":lock");

            } else {//没有拿到缓存锁
                //自旋
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getSkuById(skuId);

            }
        } else {//查询的数据在缓存中
            skuInfo = JSON.parseObject(val, SkuInfo.class);
        }
        return skuInfo;
    }

    @Override
    public List<SkuInfo> getSkuListByCatalog3Id(String catalog3Id) {
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setCatalog3Id(catalog3Id);
        List<SkuInfo> skuInfos = skuInfoMapper.select(skuInfo);

        for (SkuInfo sku :
                skuInfos) {
            SkuAttrValue skuAttrValue = new SkuAttrValue();
            skuAttrValue.setSkuId(sku.getId());
            List<SkuAttrValue> skuAttrValues = skuAttrValueMapper.select(skuAttrValue);
            sku.setSkuAttrValueList(skuAttrValues);
        }

        return skuInfos;
    }

    @Override
    public boolean checkPrice(BigDecimal skuPrice, String skuId) {
        boolean bPrice = false;
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setId(skuId);
        SkuInfo sku = skuInfoMapper.selectOne(skuInfo);
        if (sku != null) {
            int i = sku.getPrice().compareTo(skuPrice);
            if (i == 0) {
                bPrice = true;
            }
        }

        return bPrice;
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

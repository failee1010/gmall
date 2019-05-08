package com.lee.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lee.gmall.bean.SkuInfo;
import com.lee.gmall.bean.SpuInfo;
import com.lee.gmall.bean.SpuSaleAttr;
import com.lee.gmall.service.SkuService;
import com.lee.gmall.service.SpuService;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SkuController {

    @Reference
    SkuService skuService;


    @RequestMapping("getSkuListBySpuId")
    @ResponseBody
    public List<SkuInfo> getSkuListBySpuId(String spuId) {
        return skuService.getSkuListBySpuId(spuId);
    }

    @RequestMapping("saveSku")
    @ResponseBody
    public String saveSku(SkuInfo skuInfo) {
        skuService.saveSku(skuInfo);
        return "success";
    }




}

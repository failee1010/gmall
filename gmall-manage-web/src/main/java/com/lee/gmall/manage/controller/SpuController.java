package com.lee.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lee.gmall.bean.*;
import com.lee.gmall.manage.util.MyUploadUtil;
import com.lee.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class SpuController {

    @Reference
    SpuService spuService;

    @RequestMapping("spuList")
    @ResponseBody
    public List<SpuInfo> spuList(String catalog3Id) {
        List<SpuInfo> spuInfos = spuService.spuList(catalog3Id);
        return spuInfos;
    }

    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<BaseSaleAttr> baseSaleAttrList() {
        List<BaseSaleAttr> baseSaleAttrs = spuService.baseSaleAttrList();
        return baseSaleAttrs;
    }

    //由编辑SPU页的保存按钮所调用，保存SPU页面信息
    @RequestMapping("saveSpu")
    @ResponseBody
    public String saveSpu(SpuInfo spuInfo) {
        spuService.saveSpu(spuInfo);
        return "success";

    }

    //将图片上传到fdfs并返回url
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        return MyUploadUtil.uploadImage(file);
    }

    // 把商品图片列表加载到对话框中
    @RequestMapping("getSpuImageList")
    @ResponseBody
    public List<SpuImage> getSpuImageList(String spuId) {
        return spuService.getSpuImageList(spuId);
    }

    // 把销售属性列表加载到对话框中
    @RequestMapping("getSpuSaleAttrList")
    @ResponseBody
    public List<SpuSaleAttr> getSpuSaleAttrList(String spuId) {
        return spuService.getSpuSaleAttrList(spuId);
    }

    //删除选中spu的相关数据
    @RequestMapping("deleteSpu")
    @ResponseBody
    public String deleteSpu(String spuId) {
        spuService.deleteSpu(spuId);
        return "success";
    }

    @RequestMapping("getSpuSaleAttrListBySpuId")
    @ResponseBody
    public List<SpuSaleAttr> getSpuSaleAttrListBySpuId(String spuId) {
        return spuService.getSpuSaleAttrListBySpuId(spuId);

    }

    @RequestMapping("getSpuImageListBySpuId")
    @ResponseBody
    public List<SpuImage> getSpuImageListBySpuId(String spuId) {
        return spuService.getSpuImageList(spuId);
    }

}

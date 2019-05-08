package com.lee.gmall.list.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lee.gmall.bean.*;
import com.lee.gmall.service.AttrService;
import com.lee.gmall.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class ListController {

    @Reference
    SearchService searchService;

    @Reference
    AttrService attrService;

    @RequestMapping("list.html")
    public String search(SkuLsParam skuLsParam, ModelMap map) {

        //根据搜索框输入的关键字或者三级分类Id查询筛选出的商品列表
        List<SkuLsInfo> skuLsInfos = searchService.search(skuLsParam);
        map.put("skuLsInfoList", skuLsInfos);

        //根据商品列表查询出相关的平台属性列表,并排除已选中的属性,制作面包屑
        List<BaseAttrInfo> baseAttrInfos = getAttrValueIds(skuLsInfos);
        String[] valueId = skuLsParam.getValueId();
        List<Crumb> crumbs = new ArrayList<>();
        if (valueId != null && valueId.length > 0) {
            for (String s : valueId) {
                Iterator<BaseAttrInfo> iterator = baseAttrInfos.iterator();
                //制作面包屑
                Crumb crumb = new Crumb();
                String urlParamForCrumb = getUrlParam(skuLsParam, s);
                String valueName = "";
                //排除已选中的属性
                while (iterator.hasNext()) {
                    BaseAttrInfo baseAttrInfo = iterator.next();
                    List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
                    for (BaseAttrValue baseAttrValue : attrValueList) {

                        if (baseAttrValue.getId().equals(s)) {
                            valueName = baseAttrValue.getValueName();
                            crumb.setUrlParam(urlParamForCrumb);
                            crumb.setValueName(valueName);
                            crumbs.add(crumb);
                            iterator.remove();
                        }
                    }
                }

            }
        }
        map.put("attrList", baseAttrInfos);
        map.put("attrValueSelectedList", crumbs);

        //拼接平台属性值的url
        String urlParam = getUrlParam(skuLsParam,null);
        map.put("urlParam", urlParam);
        return "list";
    }

    private String getUrlParam(SkuLsParam skuLsParam,String id) {
        String urlParam = "";
        String keyword = skuLsParam.getKeyword();
        String catalog3Id = skuLsParam.getCatalog3Id();
        String[] valueId = skuLsParam.getValueId();

        if (StringUtils.isNotBlank(keyword)) {
            if (StringUtils.isBlank(urlParam)) {
                urlParam = "keyword=" + keyword;
            } else {
                urlParam = urlParam + "&keyword=" + keyword;
            }
        }
        if (StringUtils.isNotBlank(catalog3Id)) {
            if (StringUtils.isBlank(urlParam)) {
                urlParam = "catalog3Id=" + catalog3Id;
            } else {
                urlParam = urlParam + "&catalog3Id=" + catalog3Id;
            }
        }
        if (valueId != null && valueId.length > 0) {
            for (String s : valueId) {
                if (!s.equals(id)) {
                    urlParam = urlParam + "&valueId=" + s;
                }
            }
        }
        return urlParam;
    }

    private List<BaseAttrInfo> getAttrValueIds(List<SkuLsInfo> skuLsInfos) {
        Set<String> valueIds = new HashSet<>();
        for (SkuLsInfo skuLsInfo :
                skuLsInfos) {
            List<SkuLsAttrValue> skuAttrValueList = skuLsInfo.getSkuAttrValueList();
            for (SkuLsAttrValue skuAttrValue :
                    skuAttrValueList) {
                valueIds.add(skuAttrValue.getValueId());
            }
        }

        //根据去重后的valueId集合检索关联到的平台属性列表
        List<BaseAttrInfo> baseAttrInfos = new ArrayList<>();
        baseAttrInfos = attrService.getAttrListByValueIds(valueIds);
        return baseAttrInfos;
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

}

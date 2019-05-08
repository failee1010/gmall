package com.lee.gmall.service;

import com.lee.gmall.bean.SkuLsInfo;
import com.lee.gmall.bean.SkuLsParam;

import java.util.List;

public interface SearchService {

    List<SkuLsInfo> search(SkuLsParam skuLsParam);
}

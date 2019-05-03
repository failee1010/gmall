package com.lee.gmall.manage.mapper;

import com.lee.gmall.bean.SkuInfo;
import com.lee.gmall.bean.SpuSaleAttr;
import com.lee.gmall.bean.SpuSaleAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SpuSaleAttrValueMapper extends Mapper<SpuSaleAttrValue> {

    List<SpuSaleAttr> selectSpuSaleAttrListCheckBySku(Map<String, String> map);

    List<SkuInfo> selectSkuSaleAttrValueListBySpu(@Param("spuId") String spuId);

}

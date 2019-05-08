package com.lee.gmall.manage.mapper;

import com.lee.gmall.bean.BaseAttrInfo;
import com.lee.gmall.bean.BaseAttrValue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseAttrValueMapper extends Mapper<BaseAttrValue> {
    List<BaseAttrInfo> selectAttrListByValueIds(@Param("ids") String join);
}

package com.lee.gmall.list;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lee.gmall.bean.SkuInfo;
import com.lee.gmall.bean.SkuLsInfo;
import com.lee.gmall.service.SkuService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallListServiceApplicationTests {

    @Autowired
    JestClient jestClient;

    @Reference
    SkuService skuService;




    @Test
    public void contextLoads() {

        //查询mysql中sku信息
        List<SkuInfo> skuInfoList = skuService.getSkuListByCatalog3Id("1");
        //转化为es中的sku信息
        List<SkuLsInfo> skuLsInfos = new ArrayList<>();
        for (SkuInfo skuInfo :
                skuInfoList) {
            SkuLsInfo skuLsInfo = new SkuLsInfo();
            try {
                BeanUtils.copyProperties(skuLsInfo, skuInfo);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            skuLsInfos.add(skuLsInfo);
        }

        //导入到es中
        for (SkuLsInfo skuLsInfo :
                skuLsInfos) {
            Index index = new Index.Builder(skuLsInfo).index("gmall").type("skuLsInfo").id(skuLsInfo.getId()).build();
            System.out.println(index);
            try {
                jestClient.execute(index);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

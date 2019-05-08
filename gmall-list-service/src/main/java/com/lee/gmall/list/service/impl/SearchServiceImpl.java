package com.lee.gmall.list.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.lee.gmall.bean.SkuInfo;
import com.lee.gmall.bean.SkuLsInfo;
import com.lee.gmall.bean.SkuLsParam;
import com.lee.gmall.service.SearchService;
import com.lee.gmall.service.SkuService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    JestClient jestClient;

    @Override
    public List<SkuLsInfo> search(SkuLsParam skuLsParam) {
//        System.out.println(getMyDsl(skuLsParam));
        List<SkuLsInfo> skuLsInfos = new ArrayList<>();
        Search search = new Search.Builder(getMyDsl(skuLsParam)).addIndex("gmall").addType("skuLsInfo").build();
        try {
            SearchResult execute = jestClient.execute(search);
            List<SearchResult.Hit<SkuLsInfo, Void>> hits = execute.getHits(SkuLsInfo.class);
            for (SearchResult.Hit<SkuLsInfo, Void> hit :
                    hits) {
                SkuLsInfo skuLsInfo = hit.source;
                Map<String, List<String>> highlight = hit.highlight;
                if (highlight != null) {
                    List<String> skuName = highlight.get("skuName");
                    String s = skuName.get(0);
                    skuLsInfo.setSkuName(s);
                }
                skuLsInfos.add(skuLsInfo);
            }

//            System.out.println(skuLsInfos.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return skuLsInfos;
    }

    public static String getMyDsl(SkuLsParam skuLsParam) {

        String keyword = skuLsParam.getKeyword();
        String[] valueId = skuLsParam.getValueId();
        String catalog3Id = skuLsParam.getCatalog3Id();

        //创建一个dsl工具对象
        SearchSourceBuilder dsl = new SearchSourceBuilder();
        //创建一个先过滤后搜索的query对象
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        //query对象过滤语句
        if (StringUtils.isNoneBlank(catalog3Id)) {
            TermQueryBuilder t = new TermQueryBuilder("catalog3Id", catalog3Id);
            boolQueryBuilder.filter(t);
        }

        if (null != valueId && valueId.length > 0) {
            for (int i = 0; i < valueId.length; i++) {
                TermQueryBuilder t = new TermQueryBuilder("skuAttrValueList.valueId", valueId[i]);
                boolQueryBuilder.filter(t);
            }
        }

        //query对象搜索语句
        if (null != keyword) {
            MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("skuName", keyword);
            boolQueryBuilder.must(matchQueryBuilder);
        }

        //将query、size、from、highlight放入dsl
        dsl.query(boolQueryBuilder);
        dsl.size(50);
        dsl.from(0);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("skuName");
        highlightBuilder.preTags("<span style='color:red;font-weight:bolder;'>");
        highlightBuilder.postTags("</span>");
        dsl.highlight(highlightBuilder);

        return dsl.toString();
    }






}

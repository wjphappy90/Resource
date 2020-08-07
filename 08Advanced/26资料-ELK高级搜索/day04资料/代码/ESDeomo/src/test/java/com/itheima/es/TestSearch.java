package com.itheima.es;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

/**
 * creste by itheima.itcast
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSearch {
    @Autowired
    RestHighLevelClient client;

    //搜索全部记录
    @Test
    public void testSearchAll() throws IOException {
//        GET book/_search
//        {
//            "query": {
//                "match_all": {}
//             }
//        }
        //1构建搜索请求
        SearchRequest searchRequest = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        //获取某些字段
        searchSourceBuilder.fetchSource(new String[]{"name"}, new String[]{});

        searchRequest.source(searchSourceBuilder);

        //2执行搜索
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3获取结果
        SearchHits hits = searchResponse.getHits();

        //数据数据
        SearchHit[] searchHits = hits.getHits();
        System.out.println("--------------------------");
        for (SearchHit hit : searchHits) {
            String id = hit.getId();
            float score = hit.getScore();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println("name:" + name);
            System.out.println("description:" + description);
            System.out.println("price:" + price);
            System.out.println("==========================");

        }
    }



    //搜索分页
    @Test
    public void testSearchPage() throws IOException {
//    GET book/_search
//    {
//        "query": {
//          "match_all": {}
//       },
//        "from": 0,
//        "size": 2
//    }
        //1构建搜索请求
        SearchRequest searchRequest = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());


        //第几页
        int page=1;
        //每页几个
        int size=2;
        //下标计算
        int from=(page-1)*size;


        searchSourceBuilder.from(from);
        searchSourceBuilder.size(size);


        searchRequest.source(searchSourceBuilder);

        //2执行搜索
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3获取结果
        SearchHits hits = searchResponse.getHits();

        //数据数据
        SearchHit[] searchHits = hits.getHits();
        System.out.println("--------------------------");
        for (SearchHit hit : searchHits) {
            String id = hit.getId();
            float score = hit.getScore();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println("id:" + id);
            System.out.println("name:" + name);
            System.out.println("description:" + description);
            System.out.println("price:" + price);
            System.out.println("==========================");

        }
    }



    //ids搜索
    @Test
    public void testSearchIds() throws IOException {
//    GET /book/_search
//    {
//        "query": {
//           "ids" : {
//             "values" : ["1", "4", "100"]
//          }
//     }
//    }
        //1构建搜索请求
        SearchRequest searchRequest = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.idsQuery().addIds("1","4","100"));




        searchRequest.source(searchSourceBuilder);

        //2执行搜索
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3获取结果
        SearchHits hits = searchResponse.getHits();

        //数据数据
        SearchHit[] searchHits = hits.getHits();
        System.out.println("--------------------------");
        for (SearchHit hit : searchHits) {
            String id = hit.getId();
            float score = hit.getScore();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println("id:" + id);
            System.out.println("name:" + name);
            System.out.println("description:" + description);
            System.out.println("price:" + price);
            System.out.println("==========================");

        }
    }


    //match搜索
    @Test
    public void testSearchMatch() throws IOException {
//
//    GET /book/_search
//    {
//        "query": {
//           "match": {
//            "description": "java程序员"
//        }
//      }
//    }
        //1构建搜索请求
        SearchRequest searchRequest = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("description", "java程序员"));




        searchRequest.source(searchSourceBuilder);

        //2执行搜索
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3获取结果
        SearchHits hits = searchResponse.getHits();

        //数据数据
        SearchHit[] searchHits = hits.getHits();
        System.out.println("--------------------------");
        for (SearchHit hit : searchHits) {
            String id = hit.getId();
            float score = hit.getScore();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println("id:" + id);
            System.out.println("name:" + name);
            System.out.println("description:" + description);
            System.out.println("price:" + price);
            System.out.println("==========================");

        }
    }

    //term 搜索
    @Test
    public void testSearchTerm() throws IOException {
//
//    GET /book/_search
//    {
//        "query": {
//           "term": {
//            "description": "java程序员"
//        }
//      }
//    }
        //1构建搜索请求
        SearchRequest searchRequest = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("description", "java程序员"));




        searchRequest.source(searchSourceBuilder);

        //2执行搜索
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3获取结果
        SearchHits hits = searchResponse.getHits();

        //数据数据
        SearchHit[] searchHits = hits.getHits();
        System.out.println("--------------------------");
        for (SearchHit hit : searchHits) {
            String id = hit.getId();
            float score = hit.getScore();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println("id:" + id);
            System.out.println("name:" + name);
            System.out.println("description:" + description);
            System.out.println("price:" + price);
            System.out.println("==========================");

        }
    }


    //multi_match搜索
    @Test
    public void testSearchMultiMatch() throws IOException {
//    GET /book/_search
//    {
//        "query": {
//          "multi_match": {
//            "query": "java程序员",
//            "fields": ["name", "description"]
//        }
//      }
//    }
        //1构建搜索请求
        SearchRequest searchRequest = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery("java程序员","name","description"));




        searchRequest.source(searchSourceBuilder);

        //2执行搜索
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3获取结果
        SearchHits hits = searchResponse.getHits();

        //数据数据
        SearchHit[] searchHits = hits.getHits();
        System.out.println("--------------------------");
        for (SearchHit hit : searchHits) {
            String id = hit.getId();
            float score = hit.getScore();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println("id:" + id);
            System.out.println("name:" + name);
            System.out.println("description:" + description);
            System.out.println("price:" + price);
            System.out.println("==========================");

        }
    }
//    GET /book/_search
//    {
//        "query": {
//        "bool": {
//            "must": [
//            {
//                "multi_match": {
//                "query": "java程序员",
//                        "fields": ["name","description"]
//            }
//            }
//      ],
//            "should": [
//            {
//                "match": {
//                "studymodel": "201001"
//            }
//            }
//      ]
//        }
//    }
//    }

    //bool搜索
    @Test
    public void testSearchBool() throws IOException {
//    GET /book/_search
//    {
//        "query": {
//          "bool": {
//            "must": [
//            {
//                "multi_match": {
//                  "query": "java程序员",
//                  "fields": ["name","description"]
//            }
//            }
//      ],
//            "should": [
//            {
//                "match": {
//                "studymodel": "201001"
//            }
//            }
//      ]
//        }
//    }
//    }
        //1构建搜索请求
        SearchRequest searchRequest = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //构建multiMatch请求
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("java程序员", "name", "description");
        //构建match请求
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("studymodel", "201001");

        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
        boolQueryBuilder.must(multiMatchQueryBuilder);
        boolQueryBuilder.should(matchQueryBuilder);

        searchSourceBuilder.query(boolQueryBuilder);




        searchRequest.source(searchSourceBuilder);

        //2执行搜索
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3获取结果
        SearchHits hits = searchResponse.getHits();

        //数据数据
        SearchHit[] searchHits = hits.getHits();
        System.out.println("--------------------------");
        for (SearchHit hit : searchHits) {
            String id = hit.getId();
            float score = hit.getScore();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println("id:" + id);
            System.out.println("name:" + name);
            System.out.println("description:" + description);
            System.out.println("price:" + price);
            System.out.println("==========================");

        }
    }

//    GET /book/_search
//    {
//        "query": {
//          "bool": {
//            "must": [
//            {
//                "multi_match": {
//                "query": "java程序员",
//                        "fields": ["name","description"]
//            }
//            }
//      ],
//            "should": [
//            {
//                "match": {
//                "studymodel": "201001"
//            }
//            }
//      ],
//            "filter": {
//                "range": {
//                    "price": {
//                        "gte": 50,
//                                "lte": 90
//                    }
//                }
//
//            }
//        }
//    }
//    }

    //filter搜索
    @Test
    public void testSearchFilter() throws IOException {
//    GET /book/_search
//    {
//        "query": {
//          "bool": {
//            "must": [
//            {
//                "multi_match": {
//                "query": "java程序员",
//                        "fields": ["name","description"]
//            }
//            }
//      ],
//            "should": [
//            {
//                "match": {
//                "studymodel": "201001"
//            }
//            }
//          ],
//            "filter": {
//                "range": {
//                    "price": {
//                        "gte": 50,
//                         "lte": 90
//                    }
//                }
//
//            }
//        }
//    }
//    }
        //1构建搜索请求
        SearchRequest searchRequest = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //构建multiMatch请求
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("java程序员", "name", "description");
        //构建match请求
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("studymodel", "201001");

        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
        boolQueryBuilder.must(multiMatchQueryBuilder);
        boolQueryBuilder.should(matchQueryBuilder);

        boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(50).lte(90));

        searchSourceBuilder.query(boolQueryBuilder);


        searchRequest.source(searchSourceBuilder);

        //2执行搜索
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3获取结果
        SearchHits hits = searchResponse.getHits();

        //数据数据
        SearchHit[] searchHits = hits.getHits();
        System.out.println("--------------------------");
        for (SearchHit hit : searchHits) {
            String id = hit.getId();
            float score = hit.getScore();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println("id:" + id);
            System.out.println("name:" + name);
            System.out.println("description:" + description);
            System.out.println("price:" + price);
            System.out.println("==========================");

        }
    }




    //sort搜索
    @Test
    public void testSearchSort() throws IOException {
//    GET /book/_search
//    {
//        "query": {
//        "bool": {
//            "must": [
//            {
//                "multi_match": {
//                "query": "java程序员",
//                        "fields": ["name","description"]
//            }
//            }
//      ],
//            "should": [
//            {
//                "match": {
//                "studymodel": "201001"
//            }
//            }
//      ],
//            "filter": {
//                "range": {
//                    "price": {
//                        "gte": 50,
//                                "lte": 90
//                    }
//                }
//
//            }
//        }
//    },
//        "sort": [
//        {
//            "price": {
//            "order": "asc"
//        }
//        }
//  ]
//    }
        //1构建搜索请求
        SearchRequest searchRequest = new SearchRequest("book");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //构建multiMatch请求
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("java程序员", "name", "description");
        //构建match请求
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("studymodel", "201001");

        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
        boolQueryBuilder.must(multiMatchQueryBuilder);
        boolQueryBuilder.should(matchQueryBuilder);

        boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(50).lte(90));

        searchSourceBuilder.query(boolQueryBuilder);

        //按照价格升序
        searchSourceBuilder.sort("price", SortOrder.ASC);


        searchRequest.source(searchSourceBuilder);

        //2执行搜索
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3获取结果
        SearchHits hits = searchResponse.getHits();

        //数据数据
        SearchHit[] searchHits = hits.getHits();
        System.out.println("--------------------------");
        for (SearchHit hit : searchHits) {
            String id = hit.getId();
            float score = hit.getScore();
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            String name = (String) sourceAsMap.get("name");
            String description = (String) sourceAsMap.get("description");
            Double price = (Double) sourceAsMap.get("price");
            System.out.println("id:" + id);
            System.out.println("name:" + name);
            System.out.println("description:" + description);
            System.out.println("price:" + price);
            System.out.println("==========================");
        }
    }

}

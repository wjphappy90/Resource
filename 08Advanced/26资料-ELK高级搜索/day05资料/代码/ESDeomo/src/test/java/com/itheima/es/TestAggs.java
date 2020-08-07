package com.itheima.es;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.histogram.*;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 * creste by itheima.itcast
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestAggs {
    @Autowired
    RestHighLevelClient client;

    //需求一：按照颜色分组，计算每个颜色卖出的个数
    @Test
    public void testAggs() throws IOException {
        // GET /tvs/_search
        // {
        //     "size": 0,
        //     "query": {"match_all": {}},
        //     "aggs": {
        //       "group_by_color": {
        //         "terms": {
        //             "field": "color"
        //         }
        //     }
        // }
        // }

        //1 构建请求
        SearchRequest searchRequest=new SearchRequest("tvs");

        //请求体
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        searchSourceBuilder.size(0);
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("group_by_color").field("color");
        searchSourceBuilder.aggregation(termsAggregationBuilder);

        //请求体放入请求头
        searchRequest.source(searchSourceBuilder);

        //2 执行
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3 获取结果
      //   "aggregations" : {
      //       "group_by_color" : {
      //           "doc_count_error_upper_bound" : 0,
      //           "sum_other_doc_count" : 0,
      //            "buckets" : [
      //           {
      //               "key" : "红色",
      //               "doc_count" : 4
      //           },
      //           {
      //               "key" : "绿色",
      //                   "doc_count" : 2
      //           },
      //           {
      //               "key" : "蓝色",
      //                   "doc_count" : 2
      //           }
      // ]
      //       }
        Aggregations aggregations = searchResponse.getAggregations();
        Terms group_by_color = aggregations.get("group_by_color");
        List<? extends Terms.Bucket> buckets = group_by_color.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            String key = bucket.getKeyAsString();
            System.out.println("key:"+key);

            long docCount = bucket.getDocCount();
            System.out.println("docCount:"+docCount);

            System.out.println("=================================");
        }
    }

    // #需求二：按照颜色分组，计算每个颜色卖出的个数，每个颜色卖出的平均价格
    @Test
    public void testAggsAndAvg() throws IOException {
        // GET /tvs/_search
        // {
        //     "size": 0,
        //      "query": {"match_all": {}},
        //     "aggs": {
        //     "group_by_color": {
        //         "terms": {
        //             "field": "color"
        //         },
        //         "aggs": {
        //             "avg_price": {
        //                 "avg": {
        //                     "field": "price"
        //                 }
        //             }
        //         }
        //     }
        // }
        // }

        //1 构建请求
        SearchRequest searchRequest=new SearchRequest("tvs");

        //请求体
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        searchSourceBuilder.size(0);
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("group_by_color").field("color");

        //terms聚合下填充一个子聚合
        AvgAggregationBuilder avgAggregationBuilder = AggregationBuilders.avg("avg_price").field("price");
        termsAggregationBuilder.subAggregation(avgAggregationBuilder);

        searchSourceBuilder.aggregation(termsAggregationBuilder);

        //请求体放入请求头
        searchRequest.source(searchSourceBuilder);

        //2 执行
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3 获取结果
        // {
        //     "key" : "红色",
        //      "doc_count" : 4,
        //      "avg_price" : {
        //        "value" : 3250.0
        //       }
        // }
        Aggregations aggregations = searchResponse.getAggregations();
        Terms group_by_color = aggregations.get("group_by_color");
        List<? extends Terms.Bucket> buckets = group_by_color.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            String key = bucket.getKeyAsString();
            System.out.println("key:"+key);

            long docCount = bucket.getDocCount();
            System.out.println("docCount:"+docCount);

            Aggregations aggregations1 = bucket.getAggregations();
            Avg avg_price = aggregations1.get("avg_price");
            double value = avg_price.getValue();
            System.out.println("value:"+value);

            System.out.println("=================================");
        }
    }

    // #需求三：按照颜色分组，计算每个颜色卖出的个数，以及每个颜色卖出的平均值、最大值、最小值、总和。
    @Test
    public void testAggsAndMore() throws IOException {
        // GET /tvs/_search
        // {
        //     "size" : 0,
        //     "aggs": {
        //      "group_by_color": {
        //         "terms": {
        //             "field": "color"
        //         },
        //         "aggs": {
        //             "avg_price": { "avg": { "field": "price" } },
        //             "min_price" : { "min": { "field": "price"} },
        //             "max_price" : { "max": { "field": "price"} },
        //             "sum_price" : { "sum": { "field": "price" } }
        //         }
        //     }
        // }
        // }

        //1 构建请求
        SearchRequest searchRequest=new SearchRequest("tvs");

        //请求体
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        searchSourceBuilder.size(0);
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("group_by_color").field("color");


        //termsAggregationBuilder里放入多个子聚合
        AvgAggregationBuilder avgAggregationBuilder = AggregationBuilders.avg("avg_price").field("price");
        MinAggregationBuilder minAggregationBuilder = AggregationBuilders.min("min_price").field("price");
        MaxAggregationBuilder maxAggregationBuilder = AggregationBuilders.max("max_price").field("price");
        SumAggregationBuilder sumAggregationBuilder = AggregationBuilders.sum("sum_price").field("price");

        termsAggregationBuilder.subAggregation(avgAggregationBuilder);
        termsAggregationBuilder.subAggregation(minAggregationBuilder);
        termsAggregationBuilder.subAggregation(maxAggregationBuilder);
        termsAggregationBuilder.subAggregation(sumAggregationBuilder);


        searchSourceBuilder.aggregation(termsAggregationBuilder);

        //请求体放入请求头
        searchRequest.source(searchSourceBuilder);

        //2 执行
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3 获取结果
        // {
        //     "key" : "红色",
        //     "doc_count" : 4,
        //     "max_price" : {
        //          "value" : 8000.0
        //     },
        //     "min_price" : {
        //          "value" : 1000.0
        // },
        //     "avg_price" : {
        //         "value" : 3250.0
        // },
        //     "sum_price" : {
        //         "value" : 13000.0
        // }
        // }
        Aggregations aggregations = searchResponse.getAggregations();
        Terms group_by_color = aggregations.get("group_by_color");
        List<? extends Terms.Bucket> buckets = group_by_color.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            String key = bucket.getKeyAsString();
            System.out.println("key:"+key);

            long docCount = bucket.getDocCount();
            System.out.println("docCount:"+docCount);

            Aggregations aggregations1 = bucket.getAggregations();

            Max max_price = aggregations1.get("max_price");
            double maxPriceValue = max_price.getValue();
            System.out.println("maxPriceValue:"+maxPriceValue);

            Min min_price = aggregations1.get("min_price");
            double minPriceValue = min_price.getValue();
            System.out.println("minPriceValue:"+minPriceValue);

            Avg avg_price = aggregations1.get("avg_price");
            double avgPriceValue = avg_price.getValue();
            System.out.println("avgPriceValue:"+avgPriceValue);

            Sum sum_price = aggregations1.get("sum_price");
            double sumPriceValue = sum_price.getValue();
            System.out.println("sumPriceValue:"+sumPriceValue);

            System.out.println("=================================");
        }
    }

    // #需求四：按照售价每2000价格划分范围，算出每个区间的销售总额 histogram
    @Test
    public void testAggsAndHistogram() throws IOException {
        // GET /tvs/_search
        // {
        //     "size" : 0,
        //     "aggs":{
        //      "by_histogram":{
        //         "histogram":{
        //             "field": "price",
        //             "interval": 2000
        //         },
        //         "aggs":{
        //             "income": {
        //                 "sum": {
        //                     "field" : "price"
        //                 }
        //             }
        //         }
        //     }
        // }
        // }

        //1 构建请求
        SearchRequest searchRequest=new SearchRequest("tvs");

        //请求体
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        searchSourceBuilder.size(0);
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        HistogramAggregationBuilder histogramAggregationBuilder = AggregationBuilders.histogram("by_histogram").field("price").interval(2000);

        SumAggregationBuilder sumAggregationBuilder = AggregationBuilders.sum("income").field("price");
        histogramAggregationBuilder.subAggregation(sumAggregationBuilder);
        searchSourceBuilder.aggregation(histogramAggregationBuilder);

        //请求体放入请求头
        searchRequest.source(searchSourceBuilder);

        //2 执行
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3 获取结果
        // {
        //     "key" : 0.0,
        //     "doc_count" : 3,
        //      income" : {
        //          "value" : 3700.0
        //       }
        // }
        Aggregations aggregations = searchResponse.getAggregations();
        Histogram group_by_color = aggregations.get("by_histogram");
        List<? extends Histogram.Bucket> buckets = group_by_color.getBuckets();
        for (Histogram.Bucket bucket : buckets) {
            String keyAsString = bucket.getKeyAsString();
            System.out.println("keyAsString:"+keyAsString);
            long docCount = bucket.getDocCount();
            System.out.println("docCount:"+docCount);

            Aggregations aggregations1 = bucket.getAggregations();
            Sum income = aggregations1.get("income");
            double value = income.getValue();
            System.out.println("value:"+value);

            System.out.println("=================================");

        }
    }

    // #需求五：计算每个季度的销售总额
    @Test
    public void testAggsAndDateHistogram() throws IOException {
        // GET /tvs/_search
        // {
        //     "size" : 0,
        //     "aggs": {
        //     "sales": {
        //         "date_histogram": {
        //                      "field": "sold_date",
        //                     "interval": "quarter",
        //                     "format": "yyyy-MM-dd",
        //                     "min_doc_count" : 0,
        //                     "extended_bounds" : {
        //                         "min" : "2019-01-01",
        //                         "max" : "2020-12-31"
        //             }
        //         },
        //         "aggs": {
        //             "income": {
        //                 "sum": {
        //                     "field": "price"
        //                 }
        //             }
        //         }
        //     }
        // }
        // }

        //1 构建请求
        SearchRequest searchRequest=new SearchRequest("tvs");

        //请求体
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        searchSourceBuilder.size(0);
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        DateHistogramAggregationBuilder dateHistogramAggregationBuilder = AggregationBuilders.dateHistogram("date_histogram").field("sold_date").calendarInterval(DateHistogramInterval.QUARTER)
                .format("yyyy-MM-dd").minDocCount(0).extendedBounds(new ExtendedBounds("2019-01-01", "2020-12-31"));
        SumAggregationBuilder sumAggregationBuilder = AggregationBuilders.sum("income").field("price");
        dateHistogramAggregationBuilder.subAggregation(sumAggregationBuilder);

        searchSourceBuilder.aggregation(dateHistogramAggregationBuilder);
        //请求体放入请求头
        searchRequest.source(searchSourceBuilder);

        //2 执行
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        //3 获取结果
        // {
        //     "key_as_string" : "2019-01-01",
        //      "key" : 1546300800000,
        //      "doc_count" : 0,
        //      "income" : {
        //         "value" : 0.0
        //      }
        // }
        Aggregations aggregations = searchResponse.getAggregations();
        ParsedDateHistogram date_histogram = aggregations.get("date_histogram");
        List<? extends Histogram.Bucket> buckets = date_histogram.getBuckets();
        for (Histogram.Bucket bucket : buckets) {
            String keyAsString = bucket.getKeyAsString();
            System.out.println("keyAsString:"+keyAsString);
            long docCount = bucket.getDocCount();
            System.out.println("docCount:"+docCount);

            Aggregations aggregations1 = bucket.getAggregations();
            Sum income = aggregations1.get("income");
            double value = income.getValue();
            System.out.println("value:"+value);

            System.out.println("====================");
        }

    }


}

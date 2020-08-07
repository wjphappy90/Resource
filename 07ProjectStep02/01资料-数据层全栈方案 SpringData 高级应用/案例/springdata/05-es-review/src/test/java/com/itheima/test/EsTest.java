package com.itheima.test;

import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EsTest {
    TransportClient client = null;

    //创建连接
    @Before
    public void initClient() {
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(
                            new InetSocketTransportAddress(
                                    InetAddress.getByName("192.168.106.128"), 9300
                            )
                    );
        } catch (UnknownHostException e) {
            System.out.println("初始化失败....");
            e.printStackTrace();
        }
    }

    //关闭连接
    @After
    public void closeClient() {
        client.close();
    }

    //创建索引
    @Test
    public void testCreateIndex() throws UnknownHostException {
        client.admin().indices().prepareCreate("heima").get();
    }

    //删除索引,可以一次性删除多个
    @Test
    public void testDeleteIndex() throws UnknownHostException {
        client.admin().indices().prepareDelete("heima1").get();
    }

    //创建映射
    @Test
    public void testCreateMappping() throws Exception {
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .startObject("article")
                .startObject("properties")

                .startObject("title")
                .field("type", "string")
                .field("store", "yes")
                .field("analyzer", "ik_smart")
                .endObject()

                .startObject("content")
                .field("type", "string")
                .field("store", "yes")
                .field("analyzer", "ik_smart")
                .endObject()

                .startObject("hits")
                .field("type", "long")
                .field("store", "yes")
                .endObject()

                .endObject()
                .endObject()
                .endObject();

        // 创建映射(表结构)
        PutMappingRequest mapping = Requests.putMappingRequest("heima")//指定索引(库)
                .type("article")//指定类型(表)
                .source(builder);
        client.admin().indices().putMapping(mapping).get();
    }

    //创建文档
    @Test
    public void testCreateDocuments() {

        //组装数据
        Map<String, Object> map = new HashMap<>();
        map.put("title", "黑马程序员");
        map.put("content", "黑马程序员其实很低调");
        map.put("hits", 100);

        //创建文档
        client.prepareIndex("heima", "article", "1").setSource(map).get();
    }


    //修改文档
    @Test
    public void testUpdateDocuments() {

        //组装数据
        Map<String, Object> map = new HashMap<>();
        map.put("title", "传智播客2");
        map.put("content", "传智播客很低调2");
        map.put("hits", 200);

        //修改文档
        client.prepareUpdate("heima", "article", "1").setDoc(map).get();
    }


    //删除文档
    @Test
    public void testDeleteDocuments() {
        client.prepareDelete("heima", "article", "1").get();
    }


    //创建文档
    @Test
    public void testCreateDocumentsForQuery() {
        for (int i = 1; i <= 20; i++) {
            //组装数据
            Map<String, Object> map = new HashMap<>();
            map.put("title", "黑马程序员" + i);
            map.put("content", "黑马程序员其实很低调" + i);
            map.put("hits", 100 + i);

            //创建文档
            client.prepareIndex("heima", "article", i + "").setSource(map).get();
        }
    }

    //查询所有
    @Test
    public void testFindAll() {

        //1 设置index type  查询条件,返回一个查询结果对象
        SearchResponse searchResponse = client.prepareSearch("heima").setTypes("article")//设置index和type,允许传入多个
                .setQuery(QueryBuilders.matchAllQuery())//设置查询条件 :查询所有
                .get();

        //2 检索的命中对象
        SearchHits hits = searchResponse.getHits();

        //3 获取查询结果数
        System.out.println("总共查询到" + hits.getTotalHits() + "条记录");

        //4 获取结果
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next();
            System.out.println(searchHit.getSourceAsString());
        }
    }



    //根据title查询
    @Test
    public void testFindByTitle() {

        //QueryBuilders.termQuery("属性","值[分词之后存在]")
        //1 设置index type  查询条件,返回一个查询结果对象
        SearchResponse searchResponse = client.prepareSearch("heima").setTypes("article")//设置index和type,允许传入多个
                .setQuery(QueryBuilders.termQuery("title","员"))//设置查询条件 :根据title查询
                .get();

        //2 检索的命中对象
        SearchHits hits = searchResponse.getHits();

        //3 获取查询结果数
        System.out.println("总共查询到" + hits.getTotalHits() + "条记录");

        //4 获取结果
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next();
            System.out.println(searchHit.getSourceAsString());
        }
    }



    //分页和排序
    @Test
    public void testFindAllWithPageAndSort() {

        //1 设置index type  查询条件,返回一个查询结果对象
        SearchResponse searchResponse = client.prepareSearch("heima").setTypes("article")//设置index和type,允许传入多个
                .setQuery(QueryBuilders.matchAllQuery())//设置查询条件 :查询所有
                .setFrom(0).setSize(20)//设置分页的条件 .setFrom(从第几行开始查).setSize(查多少行)
                .addSort("hits", SortOrder.ASC)//设置分页条件 .addSort(属性, 排序规则)
                .get();

        //2 检索的命中对象
        SearchHits hits = searchResponse.getHits();//20

        //3 获取查询结果数
        System.out.println("总共查询到" + hits.getTotalHits() + "条记录");

        //4 获取结果
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next();
            System.out.println(searchHit.getSourceAsString());
        }
    }




}

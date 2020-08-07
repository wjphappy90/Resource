package com.itheima.es;


import org.apache.http.nio.reactor.ListenerEndpoint;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.close.CloseIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse;
import org.elasticsearch.action.support.ActiveShardCount;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestIndex {

    @Autowired
    RestHighLevelClient client;

//    @Autowired
//    RestClient restClient;

    //创建索引
    @Test
    public void testCreateIndex() throws IOException {
//        PUT /my_index
//        {
//            "settings": {
//            "number_of_shards": 1,
//                    "number_of_replicas": 1
//        },
//            "mappings": {
//            "properties": {
//                "field1":{
//                    "type": "text"
//                },
//                "field2":{
//                    "type": "text"
//                }
//            }
//        },
//            "aliases": {
//            "default_index": {}
//        }
//        }


        //创建索引对象
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("itheima_book");
        //设置参数
        createIndexRequest.settings(Settings.builder().put("number_of_shards", "1").put("number_of_replicas", "0"));
        //指定映射1
        createIndexRequest.mapping(" {\n" +
                " \t\"properties\": {\n" +
                "            \"name\":{\n" +
                "             \"type\":\"keyword\"\n" +
                "           },\n" +
                "           \"description\": {\n" +
                "              \"type\": \"text\"\n" +
                "           },\n" +
                "            \"price\":{\n" +
                "             \"type\":\"long\"\n" +
                "           },\n" +
                "           \"pic\":{\n" +
                "             \"type\":\"text\",\n" +
                "             \"index\":false\n" +
                "           }\n" +
                " \t}\n" +
                "}", XContentType.JSON);

        //指定映射2
//        Map<String, Object> message = new HashMap<>();
//        message.put("type", "text");
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("message", message);
//        Map<String, Object> mapping = new HashMap<>();
//        mapping.put("properties", properties);
//        createIndexRequest.mapping(mapping);

        //指定映射3
//        XContentBuilder builder = XContentFactory.jsonBuilder();
//        builder.startObject();
//        {
//            builder.startObject("properties");
//            {
//                builder.startObject("message");
//                {
//                    builder.field("type", "text");
//                }
//                builder.endObject();
//            }
//            builder.endObject();
//        }
//        builder.endObject();
//        createIndexRequest.mapping(builder);


        //设置别名
        createIndexRequest.alias(new Alias("itheima_index_new"));

        // 额外参数
        //设置超时时间
        createIndexRequest.setTimeout(TimeValue.timeValueMinutes(2));
        //设置主节点超时时间
        createIndexRequest.setMasterTimeout(TimeValue.timeValueMinutes(1));
        //在创建索引API返回响应之前等待的活动分片副本的数量，以int形式表示
        createIndexRequest.waitForActiveShards(ActiveShardCount.from(2));
        createIndexRequest.waitForActiveShards(ActiveShardCount.DEFAULT);

        //操作索引的客户端
        IndicesClient indices = client.indices();
        //执行创建索引库
        CreateIndexResponse createIndexResponse = indices.create(createIndexRequest, RequestOptions.DEFAULT);

        //得到响应（全部）
        boolean acknowledged = createIndexResponse.isAcknowledged();
        //得到响应 指示是否在超时前为索引中的每个分片启动了所需数量的碎片副本
        boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();

        System.out.println("acknowledged:" + acknowledged);
        System.out.println("shardsAcknowledged:" + shardsAcknowledged);

    }

    //创建索引异步方式
    @Test
    public void testCreateIndexAsync() throws IOException {

        //创建索引对象
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("itheima_book");
        //设置参数
        createIndexRequest.settings(Settings.builder().put("number_of_shards", "1").put("number_of_replicas", "0"));
        //指定映射1
        createIndexRequest.mapping(" {\n" +
                " \t\"properties\": {\n" +
                "            \"name\":{\n" +
                "             \"type\":\"keyword\"\n" +
                "           },\n" +
                "           \"description\": {\n" +
                "              \"type\": \"text\"\n" +
                "           },\n" +
                "            \"price\":{\n" +
                "             \"type\":\"long\"\n" +
                "           },\n" +
                "           \"pic\":{\n" +
                "             \"type\":\"text\",\n" +
                "             \"index\":false\n" +
                "           }\n" +
                " \t}\n" +
                "}", XContentType.JSON);

        //指定映射2
//        Map<String, Object> message = new HashMap<>();
//        message.put("type", "text");
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("message", message);
//        Map<String, Object> mapping = new HashMap<>();
//        mapping.put("properties", properties);
//        createIndexRequest.mapping(mapping);

        //指定映射3
//        XContentBuilder builder = XContentFactory.jsonBuilder();
//        builder.startObject();
//        {
//            builder.startObject("properties");
//            {
//                builder.startObject("message");
//                {
//                    builder.field("type", "text");
//                }
//                builder.endObject();
//            }
//            builder.endObject();
//        }
//        builder.endObject();
//        createIndexRequest.mapping(builder);


        //设置别名
        createIndexRequest.alias(new Alias("itheima_index_new"));

        // 额外参数
        //设置超时时间
        createIndexRequest.setTimeout(TimeValue.timeValueMinutes(2));
        //设置主节点超时时间
        createIndexRequest.setMasterTimeout(TimeValue.timeValueMinutes(1));
        //在创建索引API返回响应之前等待的活动分片副本的数量，以int形式表示
        createIndexRequest.waitForActiveShards(ActiveShardCount.from(2));
        createIndexRequest.waitForActiveShards(ActiveShardCount.DEFAULT);

        //操作索引的客户端
        IndicesClient indices = client.indices();
        //执行创建索引库
//        CreateIndexResponse createIndexResponse = indices.create(createIndexRequest, RequestOptions.DEFAULT);
        ActionListener<CreateIndexResponse> listener = new ActionListener<CreateIndexResponse>() {
            @Override
            public void onResponse(CreateIndexResponse createIndexResponse) {
                //得到响应（全部）
                boolean acknowledged = createIndexResponse.isAcknowledged();
                //得到响应 指示是否在超时前为索引中的每个分片启动了所需数量的碎片副本
                boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();

                System.out.println("acknowledged:" + acknowledged);
                System.out.println("shardsAcknowledged:" + shardsAcknowledged);
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
            }
        };

        client.indices().createAsync(createIndexRequest, RequestOptions.DEFAULT, listener);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    //    删除索引
    @Test
    public void testDeleteIndex() throws IOException {
        //创建删除索引请求
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("itheima_book");
        //        执行
        AcknowledgedResponse delete = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        //得到相应
        boolean acknowledged = delete.isAcknowledged();
        System.out.println("acknowledged:" + acknowledged);

    }


    //    删除索引异步操作
    @Test
    public void testDeleteIndexAsync() throws IOException {
        //创建删除索引请求
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("itheima_book");
        //        执行
        ActionListener<AcknowledgedResponse> listener = new ActionListener<AcknowledgedResponse>() {
            @Override
            public void onResponse(AcknowledgedResponse acknowledgedResponse) {
                //得到相应
                boolean acknowledged = acknowledgedResponse.isAcknowledged();
                System.out.println("acknowledged:" + acknowledged);
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
            }
        };


//        AcknowledgedResponse delete = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);

    }

    //index exist api
    @Test
    public void testExistIndex() throws IOException {
        GetIndexRequest request=new GetIndexRequest("itheima_book");
        //参数
        request.local(false);//从主节点返回本地索引信息状态
        request.humanReadable(true);//以适合人类的格式返回
        request.includeDefaults(false);//是否返回每个索引的所有默认配置

        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println("exists:"+exists);

    }

    //关闭索引
    @Test
    public void testCloseIndex() throws IOException {
        CloseIndexRequest request=new CloseIndexRequest("itheima_book");

        AcknowledgedResponse close = client.indices().close(request, RequestOptions.DEFAULT);

        boolean acknowledged = close.isAcknowledged();
        System.out.println("acknowledged:"+acknowledged);
    }

    //开启索引
    @Test
    public void testOpenIndex() throws IOException {
        OpenIndexRequest request=new OpenIndexRequest("itheima_book");

        OpenIndexResponse open = client.indices().open(request, RequestOptions.DEFAULT);

        boolean acknowledged = open.isAcknowledged();
        System.out.println("acknowledged:"+acknowledged);

    }



}

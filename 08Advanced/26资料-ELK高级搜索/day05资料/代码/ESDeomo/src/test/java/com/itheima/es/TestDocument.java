package com.itheima.es;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.MacAddressProvider;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * creste by itheima.itcast
 */
@SpringBootTest(classes = SearchApplication.class)
@RunWith(SpringRunner.class)
public class TestDocument {
    @Autowired
    RestHighLevelClient client;

    @Test
    public void testGet() throws IOException {
//      1构建请求

        GetRequest getRequest = new GetRequest("test_post", "1");
//        ===========可选参数==========
//        String[] includes=new String[]{"user","message"};
//        String[] excludes= Strings.EMPTY_ARRAY;
//        FetchSourceContext fetchSourceContext=new FetchSourceContext(true, includes, excludes);
//        getRequest.fetchSourceContext(fetchSourceContext);

//        String[] includes=Strings.EMPTY_ARRAY;
//        String[] excludes= new String[]{"user","message"};
//        FetchSourceContext fetchSourceContext=new FetchSourceContext(true, includes, excludes);
//        getRequest.fetchSourceContext(fetchSourceContext);

//        getRequest.routing("routing");


//      2执行
//        同步查询
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);

        //异步查询
//        ActionListener<GetResponse> listener=new ActionListener<GetResponse>() {
//            //成功时
//            public void onResponse(GetResponse getResponse) {
//                System.out.println(getResponse.getId());
////                System.out.println(getResponse.getVersion());
////                System.out.println(getResponse.getSourceAsString());
//            }
//            //失败时
//            public void onFailure(Exception e) {
//                e.printStackTrace();
//            }
//        };
//
//        client.getAsync(getRequest, RequestOptions.DEFAULT, listener);
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//      3获取结果
        if (getResponse.isExists()) {
            System.out.println(getResponse.getId());
            System.out.println(getResponse.getVersion());
            System.out.println(getResponse.getSourceAsString());//以string获取数据
            System.out.println(getResponse.getSourceAsBytes());////以Bytes获取数据
            System.out.println(getResponse.getSourceAsMap());//以Map获取数据

        } else {

        }


    }

    @Test
    public void testAdd() throws IOException {
//    PUT test_post/_doc/2
//    {
//        "user":"tomas",
//         "postDate":"2019-07-18",
//         "message":"trying out es1"
//    }


//        1构建请求
        IndexRequest request = new IndexRequest("test_post");
        request.id("5");

//    ======================构建文档数据=======================
        //方法1
        String jsonString = "{\n" +
                "  \"user\":\"tomas\",\n" +
                "  \"postDate\":\"2019-07-18\",\n" +
                "  \"message\":\"trying out es1\"\n" +
                "}";
        request.source(jsonString, XContentType.JSON);

        //方法2
//        Map<String, Object> jsonMap = new HashMap<String, Object>();
//        jsonMap.put("user", "tomas");
//        jsonMap.put("postDate", "2019-07-18");
//        jsonMap.put("message", "trying out es1");
//        request.source(jsonMap);

        //方法3
//        XContentBuilder builder = XContentFactory.jsonBuilder();
//        builder.startObject();
//        {
//            builder.field("user", "tomas");
//            builder.field("message", "trying out es1");
//            builder.timeField("postDate", "2019-07-18");
//        }
//        builder.endObject();
//        request.source(builder);

        //方法4
//        request.source("user", "tomas",
//                "message", "trying out es1",
//                "postDate", "2019-07-18");


//        =====可选参数==
        //设置超时时间
//        request.timeout("1s");
//        request.timeout(TimeValue.timeValueSeconds(1));

        //手动维护版本号
//        request.version(4);
//        request.versionType(VersionType.EXTERNAL);


//        2执行
        //同步
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
//      异步
//        ActionListener<IndexResponse> listener=new ActionListener<IndexResponse>() {
//           //成功时
//            public void onResponse(IndexResponse indexResponse) {
//                System.out.println(indexResponse.getIndex());
//                System.out.println(indexResponse.getId());
//                System.out.println(indexResponse.getResult());
//            }
//            //失败时
//            public void onFailure(Exception e) {
//
//            }
//        };
//
//        client.indexAsync(request, RequestOptions.DEFAULT, listener);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        3获取结果
        System.out.println(indexResponse.getIndex());
        System.out.println(indexResponse.getId());
        System.out.println(indexResponse.getResult());

        if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
            DocWriteResponse.Result result = indexResponse.getResult();
            System.out.println("CREATE" + result);
        } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
            DocWriteResponse.Result result = indexResponse.getResult();
            System.out.println("UPDATED" + result);
        } else {

        }
//        "_shards" : {
//            "total" : 2,
//             "successful" : 1,
//             "failed" : 0
//        }
        ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
        if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
            System.out.println("处理成功的分片数少于总分片！");
        }

        if (shardInfo.getFailed() > 0) {
            for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                String reason = failure.reason();//每一个错误的原因
                System.out.println(reason);
            }
        }
    }


    @Test
    public void testUpdate() throws IOException {
//        POST test_post/_doc/3/_update
//        {
//            "doc":{
//            "user":"tomas Lee"
//        }
//        }


//        1创建请求
        UpdateRequest request = new UpdateRequest("test_post", "3");
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("user", "tomas Lee");
        request.doc(jsonMap);

//        =========可选参数========
        request.timeout("1s");

        request.retryOnConflict(3);//重试次数


//        2执行
        //同步
        UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
        //异步

//        3获取结果
        updateResponse.getId();
        updateResponse.getIndex();

        //判断结果
        if (updateResponse.getResult() == DocWriteResponse.Result.CREATED) {
            DocWriteResponse.Result result = updateResponse.getResult();
            System.out.println("CREATED：" + result);
        } else if (updateResponse.getResult() == DocWriteResponse.Result.UPDATED) {
            DocWriteResponse.Result result = updateResponse.getResult();
            System.out.println("UPDATED：" + result);
        } else if (updateResponse.getResult() == DocWriteResponse.Result.DELETED) {
            DocWriteResponse.Result result = updateResponse.getResult();
            System.out.println("DELETED：" + result);
        } else if (updateResponse.getResult() == DocWriteResponse.Result.NOOP) {
            //没有操作
            DocWriteResponse.Result result = updateResponse.getResult();
            System.out.println("NOOP：" + result);
        }


    }

    @Test
    public void testDelete() throws IOException {

//        1创建请求
        DeleteRequest request = new DeleteRequest("test_post", "3");
//可选参数

//        2执行
        DeleteResponse deleteResponse = client.delete(request, RequestOptions.DEFAULT);


//        3获取结果
        deleteResponse.getId();
        deleteResponse.getIndex();

        DocWriteResponse.Result result = deleteResponse.getResult();
        System.out.println(result);
    }

    @Test
    public void testBulk() throws IOException {
        //        1创建请求
        BulkRequest request=new BulkRequest();
//        request.add(new IndexRequest("post").id("1").source(XContentType.JSON,"field","1" ));
//        request.add(new IndexRequest("post").id("2").source(XContentType.JSON,"field","2" ));

        request.add(new UpdateRequest("post","1").doc(XContentType.JSON,"field","3" ));
        request.add(new DeleteRequest("post").id("2"));

        //        2执行
        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);



        //        3获取结果
        for (BulkItemResponse itemResponse : bulkResponse) {
            DocWriteResponse response = itemResponse.getResponse();
            switch (itemResponse.getOpType()){
                case INDEX:
                    IndexResponse indexResponse = (IndexResponse) response;
                    System.out.println("INDEX:"+indexResponse.getResult());
                    break;
                case CREATE:
                    IndexResponse createResponse = (IndexResponse) response;
                    System.out.println("CREATE:"+createResponse.getResult());
                    break;
                case UPDATE:
                    UpdateResponse updateResponse = (UpdateResponse) response;
                    System.out.println("UPDATE:"+updateResponse.getResult());
                    break;
                case DELETE:
                    DeleteResponse deleteResponse = (DeleteResponse) response;
                    System.out.println("DELETE:"+deleteResponse.getResult());
                    break;
            }


        }



    }


}

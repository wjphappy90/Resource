package com.itheima.es.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * creste by itheima.itcast
 */
@Data
@ToString
public class QueryResult<T> {
    //数据列表
    private List<T> list;
    //数据总数
    private long total;
}

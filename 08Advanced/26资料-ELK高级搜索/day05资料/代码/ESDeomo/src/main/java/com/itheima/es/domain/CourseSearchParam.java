package com.itheima.es.domain;

import lombok.Data;
import lombok.ToString;

/**
 * creste by itheima.itcast
 */
@Data
@ToString
public class CourseSearchParam {
    //关键字
    String keyword;
    //一级分类
    String mt;
    //二级分类
    String st;

    //难度等级
    String grade;

    //价格区间
    Float price_min;
    Float price_max;

    //排序字段
    String sort;
    //过虑字段
    String filter;
}

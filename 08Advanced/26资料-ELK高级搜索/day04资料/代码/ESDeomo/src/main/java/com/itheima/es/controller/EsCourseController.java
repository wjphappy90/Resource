package com.itheima.es.controller;

import com.itheima.es.domain.CoursePub;
import com.itheima.es.domain.CourseSearchParam;
import com.itheima.es.domain.QueryResponseResult;
import com.itheima.es.service.EsCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@RequestMapping("/search/course")
public class EsCourseController  {
    @Autowired
    EsCourseService esCourseService;


    @GetMapping(value="/list/{page}/{size}")
    public QueryResponseResult<CoursePub> list(@PathVariable("page") int page, @PathVariable("size") int size, CourseSearchParam courseSearchParam) {
        return esCourseService.list(page,size,courseSearchParam);
    }


}

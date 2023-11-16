package top.zhengru.financetrain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.zhengru.financetrain.base.PageResult;
import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.entity.CourseInfo;
import top.zhengru.financetrain.param.CourseParam;
import top.zhengru.financetrain.service.CourseInfoService;
import top.zhengru.financetrain.service.CourseTypeService;

import java.util.List;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/11/16
 * @Time: 11:53
 */
@RestController
public class CourseController {
    @Autowired
    CourseInfoService courseInfoService;

    /**
     * 获取课程
     * @param courseParam
     * @return
     */
    @PostMapping("/getCourse")
    public ResponseResult<PageResult> getCourse(@RequestBody CourseParam courseParam) {
        return courseInfoService.getCourse(courseParam);
    }
}
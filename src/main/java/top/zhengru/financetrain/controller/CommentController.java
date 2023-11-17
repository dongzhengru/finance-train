package top.zhengru.financetrain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhengru.financetrain.base.PageResult;
import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.entity.Comment;
import top.zhengru.financetrain.param.CourseParam;
import top.zhengru.financetrain.service.CommentService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/11/17
 * @Time: 8:59
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    /**
     * 新增评论
     * @param comment
     * @return
     */
    @PostMapping("/save")
    public ResponseResult<Map<String, String>> addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }


    /**
     * 获取评论
     * @param foreignId
     * @return
     */
    @GetMapping
    public ResponseResult<List<Comment>> list(@RequestParam Integer foreignId){
        return commentService.findAllByForeignId(foreignId);
    }
}

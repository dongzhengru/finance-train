package top.zhengru.financetrain.service;

import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author 董政儒
* @description 针对表【comment】的数据库操作Service
* @createDate 2023-11-17 08:59:03
*/
public interface CommentService extends IService<Comment> {

    /**
     * 添加评论
     * @param comment
     * @return
     */
    ResponseResult<Map<String, String>> addComment(Comment comment);

    /**
     * 根据业务ID查询所有评论
     * @param foreignId
     * @return
     */
    ResponseResult<List<Comment>> findAllByForeignId(Integer foreignId);
}

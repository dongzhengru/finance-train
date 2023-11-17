package top.zhengru.financetrain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.entity.Comment;
import top.zhengru.financetrain.service.CommentService;
import top.zhengru.financetrain.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author 董政儒
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2023-11-17 08:59:03
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

    @Autowired
    CommentMapper commentMapper;

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Override
    public ResponseResult<Map<String, String>> addComment(Comment comment) {
        comment.setCreateTime(LocalDateTime.now());
        Integer result = commentMapper.addComment(comment);
        if (result == 1) {
            return new ResponseResult<>(200, "评论成功");
        }
        return new ResponseResult<>(500, "评论失败");
    }

    /**
     * 根据业务ID查询所有评论
     * @param foreignId
     * @return
     */
    @Override
    public ResponseResult<List<Comment>> findAllByForeignId(Integer foreignId) {
        List<Comment> commentList = commentMapper.findAllByForeignId(foreignId);
        List<Comment> rootComments = commentList.stream().filter(comment -> comment.getParentId() == null).collect(Collectors.toList());
        for (Comment rootComment : rootComments) {
            rootComment.setChildren(commentList.stream().filter(comment -> rootComment.getId().equals(comment.getParentId())).collect(Collectors.toList()));
        }
        return new ResponseResult<>(200, rootComments);
    }
}





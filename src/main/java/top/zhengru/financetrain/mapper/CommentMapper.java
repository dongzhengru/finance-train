package top.zhengru.financetrain.mapper;

import top.zhengru.financetrain.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 董政儒
* @description 针对表【comment】的数据库操作Mapper
* @createDate 2023-11-17 08:59:03
* @Entity top.zhengru.financetrain.entity.Comment
*/
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 添加评论
     * @param comment
     * @return
     */
    Integer addComment(Comment comment);

    /**
     * 根据业务ID查询所有评论
     * @param foreignId
     * @return
     */
    List<Comment> findAllByForeignId(Integer foreignId);
}





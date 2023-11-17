package top.zhengru.financetrain.mapper;

import top.zhengru.financetrain.entity.Photo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Entity top.zhengru.financetrain.entity.Photo
 */
public interface PhotoMapper extends BaseMapper<Photo> {

    List<Photo> selectAll();
}





package top.zhengru.financetrain.service;

import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.entity.Photo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface PhotoService extends IService<Photo> {

    ResponseResult<List<Photo>> getPhoto();
}

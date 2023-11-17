package top.zhengru.financetrain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.entity.Photo;
import top.zhengru.financetrain.service.PhotoService;
import top.zhengru.financetrain.mapper.PhotoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo>
    implements PhotoService{
    @Autowired
    PhotoMapper photoMapper;

    @Override
    public ResponseResult<List<Photo>> getPhoto() {
        List<Photo> photos;
        photos=photoMapper.selectAll();
        return new ResponseResult<>(200,photos);
    }
}





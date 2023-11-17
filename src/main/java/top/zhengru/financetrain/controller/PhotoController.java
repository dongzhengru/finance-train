package top.zhengru.financetrain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.entity.Photo;
import top.zhengru.financetrain.service.PhotoService;

import java.util.List;

@RestController
public class PhotoController {
    @Autowired
    PhotoService photoService;

    /**
     * 获取图片
     * @param
     * @return
     */
    @PostMapping("/getPhoto")
    public ResponseResult<List<Photo>> getPhoto() {
        return photoService.getPhoto();
    }
}

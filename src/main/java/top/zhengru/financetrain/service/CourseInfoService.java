package top.zhengru.financetrain.service;

import top.zhengru.financetrain.base.PageResult;
import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.entity.CourseInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import top.zhengru.financetrain.param.CourseParam;

/**
* @author 董政儒
* @description 针对表【course_info】的数据库操作Service
* @createDate 2023-11-16 11:52:28
*/
public interface CourseInfoService extends IService<CourseInfo> {

    /**
     * 获取课程
     * @param courseParam
     * @return
     */
    ResponseResult<PageResult> getCourse(CourseParam courseParam);

    ResponseResult<CourseInfo> getCourseById(Integer id);
}

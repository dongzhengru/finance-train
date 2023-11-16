package top.zhengru.financetrain.mapper;

import com.github.pagehelper.Page;
import top.zhengru.financetrain.entity.CourseInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.zhengru.financetrain.param.CourseParam;
import top.zhengru.financetrain.vo.CourseInfoVO;

/**
* @author 董政儒
* @description 针对表【course_info】的数据库操作Mapper
* @createDate 2023-11-16 11:52:28
* @Entity top.zhengru.financetrain.entity.CourseInfo
*/
public interface CourseInfoMapper extends BaseMapper<CourseInfo> {

    /**
     * 获取课程
     * @param courseParam
     * @return
     */
    Page<CourseInfoVO> getCourse(CourseParam courseParam);
}





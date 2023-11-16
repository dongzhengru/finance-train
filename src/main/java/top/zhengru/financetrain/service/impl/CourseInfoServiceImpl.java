package top.zhengru.financetrain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import top.zhengru.financetrain.base.PageResult;
import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.entity.CourseInfo;
import top.zhengru.financetrain.param.CourseParam;
import top.zhengru.financetrain.service.CourseInfoService;
import top.zhengru.financetrain.mapper.CourseInfoMapper;
import org.springframework.stereotype.Service;
import top.zhengru.financetrain.vo.CourseInfoVO;

/**
* @author 董政儒
* @description 针对表【course_info】的数据库操作Service实现
* @createDate 2023-11-16 11:52:28
*/
@Service
public class CourseInfoServiceImpl extends ServiceImpl<CourseInfoMapper, CourseInfo>
    implements CourseInfoService{

    @Autowired
    CourseInfoMapper courseInfoMapper;

    /**
     * 获取课程
     * @param courseParam
     * @return
     */
    @Override
    public ResponseResult<PageResult> getCourse(CourseParam courseParam) {
        Integer page = courseParam.getPage();
        Integer pageSize = courseParam.getPageSize();
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        PageHelper.startPage(page, pageSize);
        Page<CourseInfoVO> courseInfoVOList = new Page<>();
        courseInfoVOList = courseInfoMapper.getCourse(courseParam);
        return new ResponseResult<>(200, new PageResult(courseInfoVOList.getTotal(), courseInfoVOList));
    }
}





package top.zhengru.financetrain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/11/16
 * @Time: 12:01
 */
@Data
public class CourseInfoVO {
    private Integer id;
    private Integer typeId;
    private String typeName;
    private String coverUrl;
    private String title;
    private String intro;
    private String videoUrl;
    private String level;
    private String userNumber;
    private String createBy;
    private Date createTime;
}

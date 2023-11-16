package top.zhengru.financetrain.param;

import lombok.Data;


@Data
public class CourseParam {
    private Integer page;
    private Integer pageSize;
    private String courseTypeId;
    private String courseName;
}

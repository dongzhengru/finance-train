package top.zhengru.financetrain.param;

import lombok.Data;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/9/26
 * @Time: 14:23
 */
@Data
public class SysUserParam {
    private Integer page;
    private Integer pageSize;
    private String realName;
}
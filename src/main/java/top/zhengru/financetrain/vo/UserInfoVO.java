package top.zhengru.financetrain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/9/20
 * @Time: 21:43
 */

@Data
public class UserInfoVO implements Serializable {
    private String username;
    private String realName;
    private List<String> role;
}

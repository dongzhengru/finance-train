package top.zhengru.financetrain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.service.SysUserService;
import top.zhengru.financetrain.vo.UserInfoVO;

/**
 * @Author: dongzhengru
 * @Blog: blog.zhengru.top
 * @Date: 2023/9/20
 * @Time: 21:31
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    SysUserService sysUserService;

    /**
     * 查询用户详情
     * @return
     */
    @GetMapping("/getUserInfo")
    public ResponseResult<UserInfoVO> getUserInfo(){
        return sysUserService.getUserInfo();
    }
}

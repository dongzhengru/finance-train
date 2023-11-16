package top.zhengru.financetrain.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.param.LoginUserParam;
import top.zhengru.financetrain.service.SysUserService;

import java.util.Map;


@RestController
public class LoginController {
    @Autowired
    SysUserService sysUserService;
    @PostMapping("/login")
    public ResponseResult<Map<String,String>> userLogin(@RequestBody LoginUserParam userInfo) throws JsonProcessingException {
        return sysUserService.login(userInfo);
    }
}

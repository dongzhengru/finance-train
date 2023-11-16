package top.zhengru.financetrain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import top.zhengru.financetrain.param.LoginUserParam;
import top.zhengru.financetrain.param.ModifyPwdParam;
import top.zhengru.financetrain.vo.RoleInfoVO;
import top.zhengru.financetrain.vo.UserInfoVO;

import java.util.List;
import java.util.Map;

/**
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2023-08-01 14:20:18
*/
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户ID查询权限
     * @param userId
     * @return
     */
    List<RoleInfoVO> queryPermByUserId(Integer userId);

    /**
     * 用户登录
     * @param userInfo
     * @return
     * @throws JsonProcessingException
     */
    ResponseResult<Map<String, String>> login(LoginUserParam userInfo) throws JsonProcessingException;

    /**
     * 查询用户详情
     * @return
     */
    ResponseResult<UserInfoVO> getUserInfo();

    /**
     * 根据用户id重置密码
     * @param id
     * @return
     */
    ResponseResult<Map<String, String>> resetPwd(Integer id);

    /**
     * 修改密码
     * @param modifyPwdParam
     * @return
     */
    ResponseResult<Map<String, String>> modifyPwd(ModifyPwdParam modifyPwdParam);

}

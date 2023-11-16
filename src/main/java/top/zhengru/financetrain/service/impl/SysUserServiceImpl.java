package top.zhengru.financetrain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zhengru.financetrain.base.ResponseResult;
import top.zhengru.financetrain.entity.SysUser;
import top.zhengru.financetrain.mapper.SysUserMapper;
import top.zhengru.financetrain.param.LoginUserParam;
import top.zhengru.financetrain.param.ModifyPwdParam;
import top.zhengru.financetrain.service.SysUserService;
import top.zhengru.financetrain.utils.JwtUtils;
import top.zhengru.financetrain.vo.RoleInfoVO;
import top.zhengru.financetrain.vo.UserInfoVO;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-08-01 14:20:18
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ObjectMapper objectMapper;

    /**
     * 根据用户ID查询权限
     * @param userId
     * @return
     */
    @Override
    public List<RoleInfoVO> queryPermByUserId(Integer userId) {
        return sysUserMapper.queryPermByUserId(userId);
    }

    /**
     * 用户登录
     * @param userInfo
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public ResponseResult<Map<String, String>> login(LoginUserParam userInfo) throws JsonProcessingException {
        System.out.println(userInfo.toString());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userInfo.getUsername(), userInfo.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //判断登录结果
        if (Objects.isNull(authenticate)) {
             return new ResponseResult<>(500,"登录失败");
        }

        //为了安全性的考虑，密码设置为空
        UserDetailImpl user = (UserDetailImpl) authenticate.getPrincipal();
        user.setPassword(null);

        //载荷 map,Jwt的载荷,传入做生成
        Map<String, Object> claims = new HashMap<String, Object>();
        //根据业务需要加入
        claims.put("userInfo", user);

        //获取token
        JwtUtils jwtUtils = new JwtUtils();
        String token = jwtUtils.generateJwtToken(claims);

        Map<String,String> resMap= new HashMap<>(2);
        resMap.put("token",token);

        //token存入redis并设置过期时间
        stringRedisTemplate.opsForValue()
                .set("logintoken:" + token, objectMapper.writeValueAsString(authenticate), 12, TimeUnit.HOURS);

        return new ResponseResult<>(200,"登录成功", resMap);
    }

    /**
     * 查询用户详情
     * @return
     */
    @Override
    public ResponseResult<UserInfoVO> getUserInfo() {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String username = userDetail.getUsername();

        // 管理员
        if (Objects.equals(username, "admin")) {
            UserInfoVO userInfoVO = new UserInfoVO();
            userInfoVO.setUsername(username);
            userInfoVO.setRealName("管理员");
            List<String> role = new ArrayList<>();
            role.add("管理员");
            userInfoVO.setRole(role);
            return new ResponseResult<>(200, userInfoVO);
        }

        UserInfoVO userInfoVO = sysUserMapper.getUserInfo(username);
        List<String> role = sysUserMapper.getRole(username);
        userInfoVO.setRole(role);

        return new ResponseResult<>(200, userInfoVO);
    }

    /**
     * 根据用户id重置密码
     * @param id
     * @return
     */
    @Override
    @Transactional
    public ResponseResult<Map<String, String>> resetPwd(Integer id) {
        SysUser sysUser = sysUserMapper.getUserInfoById(id);
        if (sysUser != null) {
            String pwd = bCryptPasswordEncoder.encode(sysUser.getUsername());
            sysUserMapper.resetPwd(id, pwd);
        }
        return new ResponseResult<>(200, "用户："  + sysUser.getRealName() + " 密码重置成功");
    }

    /**
     * 修改密码
     * @param modifyPwdParam
     * @return
     */
    @Override
    @Transactional
    public ResponseResult<Map<String, String>> modifyPwd(ModifyPwdParam modifyPwdParam) {
        UserDetailImpl userDetail = (UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetail.getUsername();
        if (Objects.equals(modifyPwdParam.getOldPwd(), modifyPwdParam.getNewPwd())) {
            return new ResponseResult<>(500, "请不要修改相同的密码");
        }
        String pwd = sysUserMapper.getUserPwdByUsername(username);
        if (bCryptPasswordEncoder.matches(modifyPwdParam.getOldPwd(), pwd)) {
            sysUserMapper.modifyPwd(username, bCryptPasswordEncoder.encode(modifyPwdParam.getNewPwd()));
            return new ResponseResult<>(200, "修改成功");
        }
        return new ResponseResult<>(500, "修改失败");
    }
}


package top.zhengru.financetrain.service;

import top.zhengru.financetrain.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 根据用户名查询角色
     * @param username
     * @return
     */
    List<String> queryRoleByUsername(String username);
}

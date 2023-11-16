package top.zhengru.financetrain.vo;

import lombok.Data;

import java.util.List;

@Data
public class RoleInfoVO {
    private String roleName;
    private int roleCode;
    private int rolePid;
    private List<PermInfoVO> permInfoVOList;
}

package top.zhengru.financetrain.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.zhengru.financetrain.entity.SysUser;

import java.util.Collection;
import java.util.List;

@Data
public class UserDetailImpl implements UserDetails {
    private String username;

    @JsonIgnore
    private String password;

    private List<String> roles;

    private List<GrantedAuthorityImpl> authorities;

    @JsonIgnore
    private boolean accountNonExpired;
    @JsonIgnore
    private boolean accountNonLocked;
    @JsonIgnore
    private boolean credentialsNonExpired;
    @JsonIgnore
    private boolean enabled;

    public UserDetailImpl(String username, String password, List<String> roles, List<GrantedAuthorityImpl> authorities) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.authorities = authorities;
    }

    public UserDetailImpl(SysUser sysUser, List<String> roles, List<GrantedAuthorityImpl> authorities){
        this.username = sysUser.getUsername();
        this.password = sysUser.getPassword();
        this.roles = roles;
        this.authorities = authorities;
        this.enabled = sysUser.getIsEnabled() == 1;
        this.accountNonLocked = sysUser.getIsAccountNonLocked() == 1;
        this.credentialsNonExpired = true;
        this.accountNonExpired = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

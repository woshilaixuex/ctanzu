package com.tanzu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "users")
public class User{
    private String id;
    @TableField(value = "user_name")
    private String username;
    @TableField(value = "pass_word")
    private String password;
    @TableField(value = "account_non_expired")
    private boolean accountNonExpired;
    @TableField(value = "account_non_locked")
    private boolean accountNonLocked;
    @TableField(value = "credentials_non_expired")
    private boolean credentialsNonExpired;
    @TableField(value = "enabled")
    private boolean enabled;
    @TableField(exist = false)
    private List<Role> role;
    @TableField(exist = false)
    private String vercode;
}


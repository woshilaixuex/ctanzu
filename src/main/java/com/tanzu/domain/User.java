package com.tanzu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "users")
public class User{
    private String id;
    @NotNull(message = "USERNAME_CANNOT_BE_EMPTY")
    @NotBlank(message = "USERNAME_CANNOT_BE_EMPTY")
    @TableField(value = "user_name")
    private String username;
    @NotNull(message = "PASSWORD_CANNOT_BE_EMPTY")
    @NotBlank(message = "PASSWORD_CANNOT_BE_EMPTY")
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


package com.tanzu.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_informs")
public class UserInform {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String name;
    private String massage;
    @Email
    private String email;
}

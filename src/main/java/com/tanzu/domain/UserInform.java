package com.tanzu.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_informs")
public class UserInform {
    private String id;
    private String name;
    private String massage;
    private String email;
}

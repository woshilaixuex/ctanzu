package com.tanzu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tanzu.domain.Role;
import com.tanzu.domain.User;
import com.tanzu.mapper.RoleUserMapper;
import com.tanzu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.TimeoutException;


public interface UserServiceImpl {
    User loadUserByUsername(String username) throws TimeoutException;

}

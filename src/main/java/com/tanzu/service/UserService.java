package com.tanzu.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tanzu.domain.Role;
import com.tanzu.domain.User;
import com.tanzu.mapper.RoleUserMapper;
import com.tanzu.mapper.UserMapper;
import com.tanzu.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
public class UserService implements UserServiceImpl {
    @Autowired
    RoleUserMapper roleUserMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public User loadUserByUsername(String username) throws TimeoutException {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null){
            return null;
        }
        List<Role> roles = roleUserMapper.findRolesByUserId(user.getId());
        user.setRole(roles);
        return user;
    }
}

package com.tanzu.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tanzu.domain.Role;
import com.tanzu.domain.User;
import com.tanzu.domain.UserInform;
import com.tanzu.mapper.RoleMapper;
import com.tanzu.mapper.RoleUserMapper;
import com.tanzu.mapper.UserInformMapper;
import com.tanzu.mapper.UserMapper;
import com.tanzu.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
public class UserService implements UserServiceImpl {
    @Autowired
    RoleUserMapper roleUserMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserInformMapper userInformMapper;
    @Override
    public User loadUserByUsername(String username) {
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

    @Override
    @Transactional
    public User saveNewUser(User user) {
        UserInform userInform = new UserInform();
        userInform.setId(UUID.randomUUID().toString());
        userInform.setName(user.getUsername());
        userMapper.insert(user);
        userInformMapper.insert(userInform);
        roleUserMapper.setRoleUser(1L, user.getId());
        return user;
    }
}

package com.tanzu.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tanzu.domain.Role;
import com.tanzu.domain.User;
import com.tanzu.domain.UserInform;
import com.tanzu.mapper.RoleMapper;
import com.tanzu.mapper.RoleUserMapper;
import com.tanzu.mapper.UserInformMapper;
import com.tanzu.mapper.UserMapper;
import com.tanzu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
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
        try {
            UserInform userInform = new UserInform();
            userInform.setId(UUID.randomUUID().toString().replace("-",""));
            userInform.setName(user.getUsername());
            user.setId(userInform.getId());
            userMapper.insert(user);
            userInformMapper.insert(userInform);
            roleUserMapper.setRoleUser(1L, user.getId());
            return user;
        }catch (Exception e){
            log.info(user.getUsername()+"存储失败");
            throw new RuntimeException("存储失败", e);
        }
    }
}

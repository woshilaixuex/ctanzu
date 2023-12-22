package com.tanzu.service.impl;



import com.tanzu.domain.User;





public interface UserServiceImpl {
    User loadUserByUsername(String username);
    User saveNewUser(User user);
}

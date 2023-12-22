package com.tanzu.service.impl;



import com.tanzu.domain.User;


import java.util.List;
import java.util.concurrent.TimeoutException;


public interface UserServiceImpl {
    User loadUserByUsername(String username) throws TimeoutException;

}

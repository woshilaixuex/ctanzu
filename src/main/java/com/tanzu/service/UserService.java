package com.tanzu.service;

import com.tanzu.domain.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService{

   User loadUserByUsername(String username);
   User saveNewUser(User user);
}

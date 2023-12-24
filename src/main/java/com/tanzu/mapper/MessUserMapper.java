package com.tanzu.mapper;

import com.tanzu.domain.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface MessUserMapper {
    @Transactional
    @Insert("INSERT INTO user_mess (user_id,mess_id) VALUES (#{userId}, #{messageId})")
    void saveUserMess(String userId, Integer messageId);
}

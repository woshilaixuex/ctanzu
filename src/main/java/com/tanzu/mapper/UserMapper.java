package com.tanzu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanzu.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM users WHERE user_name = #{username}")
    User selectByName(String username);
}
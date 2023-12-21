package com.tanzu.mapper;

import com.tanzu.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface RoleUserMapper {
    @Insert("INSERT INTO user_role (user_id,role_id) VALUES (#{user_id},#{role_id})")
    void setRoleUser(Long role_id, String user_id);
    @Select("SELECT r.* FROM users u JOIN user_role ur ON u.id = ur.user_id JOIN roles r ON r.id = ur.role_id WHERE u.id = #{userId};")
    List<Role> findRolesByUserId(String userId);
}

package com.tanzu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanzu.domain.UserInform;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserInformMapper extends BaseMapper<UserInform> {
    @Select("SELECT name FROM user_informs WHERE id = #{id}")
    String selectUserNameById(String id);
}

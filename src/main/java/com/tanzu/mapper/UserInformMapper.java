package com.tanzu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanzu.domain.UserInform;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserInformMapper extends BaseMapper<UserInform> {
}

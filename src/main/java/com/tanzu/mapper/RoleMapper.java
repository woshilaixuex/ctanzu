package com.tanzu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanzu.domain.Role;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}

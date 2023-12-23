package com.tanzu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanzu.domain.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}

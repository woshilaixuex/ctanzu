package com.tanzu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanzu.domain.History;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper extends BaseMapper<History> {
    List<History> selectAllHistoriesByUserId(String userId);
}

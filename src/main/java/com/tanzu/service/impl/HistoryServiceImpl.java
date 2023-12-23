package com.tanzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tanzu.domain.History;
import com.tanzu.mapper.HistoryMapper;
import com.tanzu.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryMapper historyMapper;

    @Override
    public List<History> selectAllHistoriesById(String userId) {
        QueryWrapper<History> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return historyMapper.selectList(queryWrapper);
    }
    @Transactional
    @Override
    public History saveHistory(History history) {
        historyMapper.insert(history);
        return history;
    }
}

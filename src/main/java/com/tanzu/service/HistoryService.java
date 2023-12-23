package com.tanzu.service;

import com.tanzu.domain.History;

import java.util.List;

public interface HistoryService {
    List<History> selectAllHistoriesById(String userId);
    History saveHistory(History history);
}

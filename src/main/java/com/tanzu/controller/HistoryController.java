package com.tanzu.controller;

import com.tanzu.common.ResResult;
import com.tanzu.domain.History;
import com.tanzu.service.impl.HistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/tanzu/history")
public class HistoryController {
    @Autowired
    HistoryServiceImpl historyService;
    @GetMapping("/histories/{username}")
    public ResponseEntity<ResResult> getAllHistories(@PathVariable String username){
        List<History> histories = historyService.selectAllHistoriesById(username);
        return  ResponseEntity.ok(new ResResult(200, "通过", histories));
    }
    @PostMapping("/history")
    public ResponseEntity<ResResult> saveHistory(@RequestBody History history){
        History historyReq = historyService.saveHistory(history);
        return ResponseEntity.ok(new ResResult(200, "通过", historyReq));
    }
}

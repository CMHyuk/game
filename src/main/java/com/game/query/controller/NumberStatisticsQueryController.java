package com.game.query.controller;

import com.game.query.dto.NumberStatisticsResponse;
import com.game.query.service.NumberStatisticsQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NumberStatisticsQueryController {

    private final NumberStatisticsQueryService numberStatisticsQueryService;

    @GetMapping("/number-statistics/{level}")
    public ResponseEntity<List<NumberStatisticsResponse>> getNumberStatistics(@PathVariable String level) {
        List<NumberStatisticsResponse> response = numberStatisticsQueryService.findByLevel(level);
        return ResponseEntity.ok(response);
    }

}

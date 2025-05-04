package com.game.query.controller;

import com.game.query.dto.NumberStatisticsResponse;
import com.game.query.service.NumberStatisticsQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NumberStatisticsQueryViewController {

    private final NumberStatisticsQueryService numberStatisticsQueryService;

    @GetMapping("/number-statistics/{level}")
    public String getGameRank(@PathVariable String level, Model model) {
        List<NumberStatisticsResponse> numberStatistics = numberStatisticsQueryService.findByLevel(level);

        model.addAttribute("level", level);
        model.addAttribute("numberStatistics", numberStatistics);

        return "number-statistics";
    }

}

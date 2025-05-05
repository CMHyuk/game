package com.game.query.controller;

import com.game.query.dto.RecordResponse;
import com.game.query.service.RecordQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RecordQueryViewController {

    private final RecordQueryService recordQueryService;

    @GetMapping("/record/{level}")
    public String getRecord(@PathVariable String level, Model model) {
        List<RecordResponse> records = recordQueryService.findByLevel(level);

        model.addAttribute("level", level);
        model.addAttribute("records", records);

        return "game-record";
    }

}

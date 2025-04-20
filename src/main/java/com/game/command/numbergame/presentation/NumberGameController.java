package com.game.command.numbergame.presentation;

import com.game.command.numbergame.application.NumberStatisticsService;
import com.game.command.numbergame.application.RecordService;
import com.game.command.numbergame.domain.Record;
import com.game.command.numbergame.dto.GameResult;
import com.game.command.numbergame.infrastructure.NumberGenerator;
import com.game.command.numbergame.infrastructure.NumberGeneratorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NumberGameController {

    private final NumberGeneratorFactory numberGeneratorFactory;
    private final NumberStatisticsService numberStatisticsService;
    private final RecordService recordService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/number/{level}")
    public String startGame(@PathVariable String level, Model model) {
        NumberGenerator numberGenerator = numberGeneratorFactory.getLevel(level);
        int number = numberGenerator.generateNumber();

        numberStatisticsService.save(number);

        model.addAttribute("number", number);
        model.addAttribute("level", level);

        return "play-game";
    }

    @ResponseBody
    @PostMapping("/result")
    public void saveGameResult(@RequestBody GameResult gameResult) {
        recordService.save(gameResult);
    }

    @ResponseBody
    @GetMapping("/a")
    public List<Record> findAll() {
        return recordService.findAll();
    }

}

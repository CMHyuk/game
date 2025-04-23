package com.game.command.numbergame.presentation;

import com.game.command.numbergame.application.NumberStatisticsService;
import com.game.command.numbergame.application.RecordService;
import com.game.command.numbergame.dto.GameResult;
import com.game.command.numbergame.infrastructure.NumberGenerator;
import com.game.command.numbergame.infrastructure.NumberGeneratorFactory;
import com.game.command.numbergame.infrastructure.NumberValidator;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class NumberGameController {

    private final NumberGeneratorFactory numberGeneratorFactory;
    private final NumberStatisticsService numberStatisticsService;
    private final NumberValidator numberValidator;
    private final RecordService recordService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/number/{level}")
    public String startGame(@PathVariable String level, HttpSession session, Model model) {
        NumberGenerator numberGenerator = numberGeneratorFactory.getLevel(level);
        int number = numberGenerator.generateNumber();
        numberStatisticsService.save(number);

        session.setAttribute("answer", number);
        model.addAttribute("level", level);

        return "play-game";
    }

    @ResponseBody
    @PostMapping("/result")
    public ResponseEntity<Void> checkAnswer(@RequestBody GameResult gameResult, HttpSession session) {
        int inputNumber = gameResult.inputNumber();
        Integer answer = (Integer) session.getAttribute("answer");

        numberValidator.validateNumberRange(inputNumber, answer);

        recordService.save(gameResult);
        return ResponseEntity.ok().build();
    }

}

package com.game.command.numbergame.presentation;

import com.game.command.numbergame.application.NumberStatisticsService;
import com.game.command.numbergame.infrastructure.NumberGenerator;
import com.game.command.numbergame.infrastructure.NumberGeneratorFactory;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class NumberGameViewController {

    private final NumberStatisticsService numberStatisticsService;
    private final NumberGeneratorFactory numberGeneratorFactory;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/{level}")
    public String startGame(@PathVariable String level, HttpSession session, Model model) {
        NumberGenerator numberGenerator = numberGeneratorFactory.getLevel(level);
        int number = numberGenerator.generateNumber();
        numberStatisticsService.save(level, number);

        session.setAttribute("answer", number);
        model.addAttribute("level", level);

        return "play-game";
    }

}

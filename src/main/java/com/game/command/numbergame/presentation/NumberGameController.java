package com.game.command.numbergame.presentation;

import com.game.command.numbergame.application.NumberStatisticsService;
import com.game.command.numbergame.infrastructure.NumberGenerator;
import com.game.command.numbergame.infrastructure.NumberGeneratorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NumberGameController {

    private final NumberGeneratorFactory numberGeneratorFactory;
    private final NumberStatisticsService numberStatisticsService;

    @GetMapping("/number/{level}")
    public ResponseEntity<Integer> generateNumber(@PathVariable String level) {
        NumberGenerator numberGenerator = numberGeneratorFactory.getLevel(level);
        int number = numberGenerator.generateNumber();

        numberStatisticsService.save(number);

        return ResponseEntity.ok(number);
    }

}

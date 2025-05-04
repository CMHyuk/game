package com.game.command.numbergame.presentation;

import com.game.command.numbergame.application.RecordService;
import com.game.command.numbergame.dto.GameResult;
import com.game.command.numbergame.infrastructure.NumberValidator;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NumberGameController {

    private final NumberValidator numberValidator;
    private final RecordService recordService;

    @PostMapping("/result")
    public ResponseEntity<Void> checkAnswer(@RequestBody GameResult gameResult, HttpSession session) {
        int inputNumber = gameResult.inputNumber();
        Integer answer = (Integer) session.getAttribute("answer");

        numberValidator.validateNumberRange(inputNumber, answer);

        recordService.save(gameResult);
        return ResponseEntity.ok().build();
    }

}

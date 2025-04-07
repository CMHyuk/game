package com.game.command.numbergame.generator;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toMap;

@Component
public class NumberGeneratorFactory {

    private final Map<String, NumberGenerator> numberGenerators;

    public NumberGeneratorFactory(List<NumberGenerator> numberGenerators) {
        this.numberGenerators = numberGenerators.stream()
                .collect(toMap(NumberGenerator::getLevel, numberGenerator -> numberGenerator));
    }

    public NumberGenerator getLevel(String provider) {
        return Optional.ofNullable(numberGenerators.get(provider))
                .orElseThrow(IllegalStateException::new);
    }

}

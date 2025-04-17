package com.game.command.numbergame.infrastructure;

import com.game.common.exception.BusinessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.game.command.numbergame.infrastructure.NumberGameException.NOT_EXISTS_PROVIDER;
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
                .orElseThrow(() -> BusinessException.from(NOT_EXISTS_PROVIDER));
    }

}

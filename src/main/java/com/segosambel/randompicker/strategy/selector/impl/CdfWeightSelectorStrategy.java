package com.segosambel.randompicker.strategy.selector.impl;

import com.segosambel.randompicker.data.model.Option;
import com.segosambel.randompicker.strategy.selector.SelectorStrategy;

import java.util.List;
import java.util.Random;

public class CdfWeightSelectorStrategy implements SelectorStrategy {
    private final Random random = new Random();

    @Override
    public Option select(List<Option> options) {
        if (options == null || options.isEmpty()) {
            return null;
        }

        double totalWeight = options.stream().mapToDouble(Option::getWeight).sum();
        double randomValue = random.nextDouble() * totalWeight;

        for (Option option : options) {
            randomValue -= option.getWeight();
            if (randomValue <= 0) {
                return option;
            }
        }

        return options.getLast();
    }
}

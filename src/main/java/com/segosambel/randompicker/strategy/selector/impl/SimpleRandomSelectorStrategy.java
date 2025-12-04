package com.segosambel.randompicker.strategy.selector.impl;

import com.segosambel.randompicker.data.model.Option;
import com.segosambel.randompicker.strategy.selector.SelectorStrategy;

import java.util.List;
import java.util.Random;

public class SimpleRandomSelectorStrategy implements SelectorStrategy {
    private final Random random = new Random();

    @Override
    public Option select(List<Option> options) {
        int rand = random.nextInt(options.size());
        return options.get(rand);
    }
}

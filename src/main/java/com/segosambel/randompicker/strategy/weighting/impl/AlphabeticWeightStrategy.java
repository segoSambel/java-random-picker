package com.segosambel.randompicker.strategy.weighting.impl;

import com.segosambel.randompicker.data.model.Option;
import com.segosambel.randompicker.strategy.weighting.WeightStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class AlphabeticWeightStrategy implements WeightStrategy {
    @Override
    public List<Option> applyWeights(List<Option> options) {
        List<Option> sortedOptions = options.stream()
                .sorted(Comparator.comparing(Option::getName))
                .toList();

        return IntStream.range(0, sortedOptions.size())
                .mapToObj(i -> {
                    Option option = sortedOptions.get(i);
                    option.setWeight((double) (sortedOptions.size() - i));
                    return option;
                })
                .toList();
    }
}

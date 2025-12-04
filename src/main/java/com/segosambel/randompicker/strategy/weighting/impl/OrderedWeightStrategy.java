package com.segosambel.randompicker.strategy.weighting.impl;

import com.segosambel.randompicker.data.model.Option;
import com.segosambel.randompicker.strategy.weighting.WeightStrategy;

import java.util.List;
import java.util.stream.IntStream;

public class OrderedWeightStrategy implements WeightStrategy {
    @Override
    public List<Option> applyWeights(List<Option> options) {
        if (options == null || options.isEmpty()) {
            return List.of();
        }

        int size = options.size();
        return IntStream.range(0, size)
                .mapToObj(i -> new Option(options.get(i).getName(), (double) (size - i)))
                .toList();
    }
}

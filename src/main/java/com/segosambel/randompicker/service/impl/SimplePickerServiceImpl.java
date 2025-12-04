package com.segosambel.randompicker.service.impl;

import com.segosambel.randompicker.data.model.Option;
import com.segosambel.randompicker.service.PickerService;
import com.segosambel.randompicker.strategy.selector.SelectorStrategy;
import com.segosambel.randompicker.strategy.weighting.WeightStrategy;

import java.util.List;

public class SimplePickerServiceImpl implements PickerService {

    private final WeightStrategy weightStrategy;
    private final SelectorStrategy selectorStrategy;

    public SimplePickerServiceImpl(WeightStrategy weightStrategy, SelectorStrategy selectorStrategy) {
        this.weightStrategy = weightStrategy;
        this.selectorStrategy = selectorStrategy;
    }

    @Override
    public Option pick(List<String> optionNames) {
        if (optionNames == null || optionNames.isEmpty()) {
            return null;
        }

        List<Option> initialOptions = optionNames.stream().map(Option::new).toList();
        List<Option> weightedOptions = weightStrategy.applyWeights(initialOptions);
        return selectorStrategy.select(weightedOptions);
    }
}

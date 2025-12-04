package com.segosambel.randompicker.strategy.weighting.impl;

import com.segosambel.randompicker.data.model.Option;
import com.segosambel.randompicker.strategy.weighting.WeightStrategy;

import java.util.List;

public class EqualWeightStrategy implements WeightStrategy {

    @Override
    public List<Option> applyWeights(List<Option> options) {
        for (Option option : options) {
            option.setWeight((double) 1);
        }
        return options;
    }
}

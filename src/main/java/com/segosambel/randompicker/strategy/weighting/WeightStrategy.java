package com.segosambel.randompicker.strategy.weighting;

import com.segosambel.randompicker.data.model.Option;

import java.util.List;

public interface WeightStrategy {
    List<Option> applyWeights(List<Option> options);
}

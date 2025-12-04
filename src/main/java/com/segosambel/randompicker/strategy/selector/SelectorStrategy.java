package com.segosambel.randompicker.strategy.selector;

import com.segosambel.randompicker.data.model.Option;

import java.util.List;

public interface SelectorStrategy {
    Option select(List<Option> options);
}

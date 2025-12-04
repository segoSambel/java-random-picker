package com.segosambel.randompicker.service.impl;

import com.segosambel.randompicker.data.model.Option;
import com.segosambel.randompicker.service.PickerService;
import com.segosambel.randompicker.strategy.selector.SelectorStrategy;
import com.segosambel.randompicker.strategy.weighting.WeightStrategy;

import java.util.List;
import java.util.Objects;

public class StreakPickerServiceImpl implements PickerService {

    private final WeightStrategy weightStrategy;
    private final SelectorStrategy selectorStrategy;
    private final int requiredStreak;

    public StreakPickerServiceImpl(WeightStrategy weightStrategy, SelectorStrategy selectorStrategy, int requiredStreak) {
        if (requiredStreak < 1) {
            throw new IllegalArgumentException("Required streak must be at least 1.");
        }
        this.weightStrategy = weightStrategy;
        this.selectorStrategy = selectorStrategy;
        this.requiredStreak = requiredStreak;
    }

    @Override
    public Option pick(List<String> optionNames) {
        if (optionNames == null || optionNames.isEmpty()) {
            return null;
        }

        List<Option> initialOptions = optionNames.stream().map(Option::new).toList();
        List<Option> weightedOptions = weightStrategy.applyWeights(initialOptions);

        if (weightedOptions.size() == 1) {
            return weightedOptions.getFirst();
        }

        for (Option option : weightedOptions) {
            System.out.println(option);
        }

        Option lastPickedOption = null;
        int currentStreak = 0;

        while (currentStreak < requiredStreak) {
            Option currentPick = selectorStrategy.select(weightedOptions);
            System.out.println(currentPick.getName());
            if (Objects.equals(lastPickedOption, currentPick)) {
                currentStreak++;
            } else {
                lastPickedOption = currentPick;
                currentStreak = 1;
            }
        }

        return lastPickedOption;
    }
}

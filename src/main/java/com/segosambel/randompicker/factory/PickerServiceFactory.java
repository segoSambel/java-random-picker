package com.segosambel.randompicker.factory;

import com.segosambel.randompicker.data.enums.PickerType;
import com.segosambel.randompicker.data.enums.SelectorType;
import com.segosambel.randompicker.data.enums.WeightingType;
import com.segosambel.randompicker.service.PickerService;
import com.segosambel.randompicker.service.impl.SimplePickerServiceImpl;
import com.segosambel.randompicker.service.impl.StreakPickerServiceImpl;
import com.segosambel.randompicker.strategy.selector.SelectorStrategy;
import com.segosambel.randompicker.strategy.selector.impl.CdfWeightSelectorStrategy;
import com.segosambel.randompicker.strategy.selector.impl.SimpleRandomSelectorStrategy;
import com.segosambel.randompicker.strategy.weighting.WeightStrategy;
import com.segosambel.randompicker.strategy.weighting.impl.AlphabeticWeightStrategy;
import com.segosambel.randompicker.strategy.weighting.impl.EqualWeightStrategy;
import com.segosambel.randompicker.strategy.weighting.impl.OrderedWeightStrategy;

public class PickerServiceFactory {

    public static PickerService getPicker() {
        return PickerServiceFactory.getPicker(
                PickerType.STREAK_PICKER,
                SelectorType.RANDOM_SELECTOR,
                WeightingType.EQUAL_WEIGHTING
        );
    }

    public static PickerService getPicker(PickerType pickerType, SelectorType selectorType, WeightingType weightingType) {
        PickerService pickerService = null;
        SelectorStrategy selectorStrategy = null;
        WeightStrategy weightStrategy = null;

        switch (weightingType) {
            case ALPHABETIC_WEIGHTING -> weightStrategy = new AlphabeticWeightStrategy();
            case ORDERED_WEIGHTING -> weightStrategy = new OrderedWeightStrategy();
            case EQUAL_WEIGHTING -> weightStrategy = new EqualWeightStrategy();
        }

        switch (selectorType) {
            case CDF_SELECTOR -> selectorStrategy = new CdfWeightSelectorStrategy();
            case RANDOM_SELECTOR -> selectorStrategy = new SimpleRandomSelectorStrategy();
        }

        switch (pickerType) {
            case SIMPLE_PICKER -> pickerService = new SimplePickerServiceImpl(weightStrategy, selectorStrategy);
            case STREAK_PICKER -> pickerService = new StreakPickerServiceImpl(weightStrategy, selectorStrategy, 3);
        }

        return pickerService;
    }
}

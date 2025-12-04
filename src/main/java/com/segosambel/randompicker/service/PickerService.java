package com.segosambel.randompicker.service;

import com.segosambel.randompicker.data.model.Option;

import java.util.List;

public interface PickerService {
    Option pick(List<String> optionNames);
}

package com.segosambel.randompicker.data.model;

import java.util.Objects;

public class Option {
    String name;
    Double weight;


    public Option(String name) {
        this.name = name;
        this.weight = 0.0;
    }

    public Option(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return Objects.equals(name, option.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Option{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

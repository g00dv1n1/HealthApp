package com.example.healthapp;

public class StatisticsValue {
    private float weight;
    private int step;

    public StatisticsValue(float weight, int step) {
        this.weight = weight;
        this.step = step;
    }

    @Override
    public String toString() {
        return "StatisticsValue{" +
                "weight=" + weight +
                ", step=" + step +
                '}';
    }
}

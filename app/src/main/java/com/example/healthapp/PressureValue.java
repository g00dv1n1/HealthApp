package com.example.healthapp;

import java.util.Date;

public class PressureValue {
    private int pressureUp;
    private int getPressureDown;
    private int pulseValue;
    private boolean tachoValue;
    private Date dimensionDate;

    public PressureValue(int pressureUp, int getPressureDown, int pulseValue, boolean tachoValue, Date dimensionDate) {
        this.pressureUp = pressureUp;
        this.getPressureDown = getPressureDown;
        this.pulseValue = pulseValue;
        this.tachoValue = tachoValue;
        this.dimensionDate = dimensionDate;
    }

    @Override
    public String toString() {
        return "PressureValue{" +
                "pressureUp=" + pressureUp +
                ", getPressureDown=" + getPressureDown +
                ", pulseValue=" + pulseValue +
                ", tachoValue=" + tachoValue +
                ", dimensionDate=" + dimensionDate +
                '}';
    }
}

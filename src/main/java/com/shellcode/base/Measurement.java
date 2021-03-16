package com.shellcode.base;

import java.sql.Timestamp;

/**
 * Class represents single measurement.
 */
public class Measurement {
    private Timestamp timestamp;
    private Double value;
    private Unit unit;

    /**
     * Constructor.
     *
     * @param timestamp is a timestamp which represents moment when measure was taken.
     * @param value is a measure value.
     * @param unit is a measure unit.
     */
    public Measurement(Timestamp timestamp, Double value, Unit unit) {
        this.timestamp = timestamp;
        this.value = value;
        this.unit = unit;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}

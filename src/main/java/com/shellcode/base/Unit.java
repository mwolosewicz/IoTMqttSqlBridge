package com.shellcode.base;

/**
 * Class represents unit. It should be used to descrive measurement value.
 */
public class Unit {
    private String unit;
    private String description;

    /**
     * Constructor.
     *
     * @param unit is a unit for represent value, like: hPa, F, C, PSI, etc.
     * @param description is a unit description like: "Temperature, a physical quantity that expresses hot and cold"
     */
    public Unit(String unit, String description) {
        this.unit = unit;
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

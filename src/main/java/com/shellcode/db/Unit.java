package com.shellcode.db;

import javax.persistence.*;

/**
 * Class represents unit. It should be used to descrive measurement value.
 */
@Entity
@Table(name = "si_units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "si_unit")
    private String unit;

    @Column(name = "unit_desc", columnDefinition="TEXT")
    private String description;

    /**
     * Default constructor.
     */
    public Unit() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "SI unit: " + unit + ", is: " + description;
    }
}

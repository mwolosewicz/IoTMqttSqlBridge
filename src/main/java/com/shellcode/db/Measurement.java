package com.shellcode.db;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Class represents single measurement.
 */
@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "value")
    private Double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "si_unit", referencedColumnName = "id")
    private Unit unit;

    /**
     * Default constructor.
     */
    public Measurement() {
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Measurement[ id: " + id + " value: " + value + unit.getUnit() + "]";
    }
}

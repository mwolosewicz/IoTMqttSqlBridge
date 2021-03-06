package com.shellcode.db;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class represents sensor which can collect measurements.
 */
@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "sens_number", nullable = false)
    private long sensorNumber;

    @Column(name = "sens_desc", columnDefinition="TEXT")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Measurement> measurements;

    /**
     * Constructor.
     */
    public Sensor() {
        measurements = new ArrayList<>();
    }

    /**
     * Constructor.
     *
     * @param sensorNumber is a sensor number in device.
     * @param description is a description of the sensor.
     * @param measurements it's a list of measurements.
     */
    public Sensor(long sensorNumber, String description, List<Measurement> measurements) {
        this.sensorNumber = sensorNumber;
        this.description = description;
        this.measurements = measurements;
    }

    /**
     * Constructor.
     *
     * @param sensorNumber is a sensor number in device.
     * @param description is a description of the sensor.
     */
    public Sensor(long sensorNumber, String description) {
        this.sensorNumber = sensorNumber;
        this.description = description;
        measurements = new ArrayList<>();
    }

    public void addMeasurement(Measurement measurement) {
        measurements.add(measurement);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSensorNumber() {
        return sensorNumber;
    }

    public void setSensorNumber(long sensorNumber) {
        this.sensorNumber = sensorNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }
}

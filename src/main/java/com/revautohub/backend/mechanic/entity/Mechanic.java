package com.revautohub.backend.mechanic.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mechanics")
public class Mechanic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String phoneNumber;

    private String specialization;

    private String location;

    private String availabilityStatus;

    public Mechanic() {
    }

    public Mechanic(Long id, String fullName, String phoneNumber, String specialization, String location, String availabilityStatus) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
        this.location = location;
        this.availabilityStatus = availabilityStatus;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getLocation() {
        return location;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
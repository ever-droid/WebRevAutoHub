package com.revautohub.backend.mechanic.dto;

public class MechanicRequestDTO {

    private String fullName;
    private String phoneNumber;
    private String specialization;
    private String location;
    private String availabilityStatus;

    public MechanicRequestDTO() {
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
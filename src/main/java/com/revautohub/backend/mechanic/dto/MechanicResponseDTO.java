package com.revautohub.backend.mechanic.dto;

public class MechanicResponseDTO {

    private Long id;
    private String fullName;
    private String phoneNumber;
    private String specialization;
    private String location;
    private String availabilityStatus;

    public MechanicResponseDTO() {
    }

    public MechanicResponseDTO(Long id, String fullName, String phoneNumber, String specialization, String location, String availabilityStatus) {
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
}
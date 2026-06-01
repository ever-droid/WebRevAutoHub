package com.revautohub.backend.emergency.dto;

import java.time.LocalDateTime;

public class EmergencyResponseDTO {

    private Long id;
    private String customerName;
    private String phoneNumber;
    private String carModel;
    private String problemDescription;
    private Double latitude;
    private Double longitude;
    private String status;
    private LocalDateTime createdAt;

    private Long assignedMechanicId;
    private String assignedMechanicName;
    private String assignedMechanicPhone;
    private String assignedMechanicLocation;

    public EmergencyResponseDTO(
            Long id,
            String customerName,
            String phoneNumber,
            String carModel,
            String problemDescription,
            Double latitude,
            Double longitude,
            String status,
            LocalDateTime createdAt,
            Long assignedMechanicId,
            String assignedMechanicName,
            String assignedMechanicPhone,
            String assignedMechanicLocation
    ) {
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.carModel = carModel;
        this.problemDescription = problemDescription;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.createdAt = createdAt;
        this.assignedMechanicId = assignedMechanicId;
        this.assignedMechanicName = assignedMechanicName;
        this.assignedMechanicPhone = assignedMechanicPhone;
        this.assignedMechanicLocation = assignedMechanicLocation;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getAssignedMechanicId() {
        return assignedMechanicId;
    }

    public String getAssignedMechanicName() {
        return assignedMechanicName;
    }

    public String getAssignedMechanicPhone() {
        return assignedMechanicPhone;
    }

    public String getAssignedMechanicLocation() {
        return assignedMechanicLocation;
    }
}
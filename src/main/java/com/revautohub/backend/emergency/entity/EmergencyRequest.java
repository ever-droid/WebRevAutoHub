package com.revautohub.backend.emergency.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emergency_requests")
public class EmergencyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Customer details
    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String carModel;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String problemDescription;

    // GPS location
    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double latitude;

    // Request status
    @Column(nullable = false)
    private String status = "PENDING";

    // Assigned mechanic details
    private Long assignedMechanicId;

    private String assignedMechanicName;

    private String assignedMechanicPhone;

    private String assignedMechanicLocation;

    // Time request was created
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public EmergencyRequest() {
    }

    public EmergencyRequest(
            String customerName,
            String phoneNumber,
            String carModel,
            String problemDescription,
            Double latitude,
            Double longitude
    ) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.carModel = carModel;
        this.problemDescription = problemDescription;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = "PENDING";
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAssignedMechanicId() {
        return assignedMechanicId;
    }

    public void setAssignedMechanicId(Long assignedMechanicId) {
        this.assignedMechanicId = assignedMechanicId;
    }

    public String getAssignedMechanicName() {
        return assignedMechanicName;
    }

    public void setAssignedMechanicName(String assignedMechanicName) {
        this.assignedMechanicName = assignedMechanicName;
    }

    public String getAssignedMechanicPhone() {
        return assignedMechanicPhone;
    }

    public void setAssignedMechanicPhone(String assignedMechanicPhone) {
        this.assignedMechanicPhone = assignedMechanicPhone;
    }

    public String getAssignedMechanicLocation() {
        return assignedMechanicLocation;
    }

    public void setAssignedMechanicLocation(String assignedMechanicLocation) {
        this.assignedMechanicLocation = assignedMechanicLocation;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
package com.revautohub.backend.admin.dto;

public class AssignMechanicResponseDTO {

    // ID of the emergency request that has been assigned
    private Long emergencyRequestId;

    // Name of the assigned mechanic
    private String mechanicName;

    // Phone number of the assigned mechanic
    private String mechanicPhoneNumber;

    // Status after assignment, for example ASSIGNED
    private String status;

    // Response message after mechanic assignment
    private String message;

    public Long getEmergencyRequestId() {
        return emergencyRequestId;
    }

    public void setEmergencyRequestId(Long emergencyRequestId) {
        this.emergencyRequestId = emergencyRequestId;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    public String getMechanicPhoneNumber() {
        return mechanicPhoneNumber;
    }

    public void setMechanicPhoneNumber(String mechanicPhoneNumber) {
        this.mechanicPhoneNumber = mechanicPhoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

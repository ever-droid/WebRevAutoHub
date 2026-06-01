package com.revautohub.backend.admin.dto;

public class AssignMechanicRequestDTO {

    // ID of the emergency request that admin wants to assign a mechanic to
    private Long emergencyRequestId;

    // Name of the mechanic being assigned
    private String mechanicName;

    // Phone number of the mechanic being assigned
    private String mechanicPhoneNumber;

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


}

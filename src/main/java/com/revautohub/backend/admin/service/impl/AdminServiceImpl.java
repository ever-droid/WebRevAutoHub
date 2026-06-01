package com.revautohub.backend.admin.service.impl;

import com.revautohub.backend.admin.dto.AssignMechanicRequestDTO;
import com.revautohub.backend.admin.dto.AssignMechanicResponseDTO;
import com.revautohub.backend.admin.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    // Receive mechanic assignment details from admin,
    // process the assignment,
    // and return assignment response
    @Override
    public AssignMechanicResponseDTO assignMechanic(
            AssignMechanicRequestDTO assignMechanicRequestDTO) {

        // Create response DTO
        AssignMechanicResponseDTO responseDTO =
                new AssignMechanicResponseDTO();

        // Transfer assignment data into response DTO
        responseDTO.setEmergencyRequestId(
                assignMechanicRequestDTO.getEmergencyRequestId());

        responseDTO.setMechanicName(
                assignMechanicRequestDTO.getMechanicName());

        responseDTO.setMechanicPhoneNumber(
                assignMechanicRequestDTO.getMechanicPhoneNumber());

        // Set assignment status
        responseDTO.setStatus("ASSIGNED");

        // Set success message
        responseDTO.setMessage(
                "Mechanic assigned successfully");

        return responseDTO;
    }

}

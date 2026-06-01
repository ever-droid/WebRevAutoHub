package com.revautohub.backend.emergency.service;

import com.revautohub.backend.emergency.dto.AssignMechanicDTO;
import com.revautohub.backend.emergency.dto.EmergencyRequestDTO;
import com.revautohub.backend.emergency.dto.EmergencyResponseDTO;

import java.util.List;

public interface EmergencyService {

    EmergencyResponseDTO createEmergencyRequest(
            EmergencyRequestDTO emergencyRequestDTO
    );
    List<EmergencyResponseDTO> getAllEmergencyRequests();

    EmergencyResponseDTO updateEmergencyStatus(Long id, String status);

    EmergencyResponseDTO assignMechanic(
            Long emergencyId,
            AssignMechanicDTO assignMechanicDTO
    );

    EmergencyResponseDTO getEmergencyById(Long id);

}

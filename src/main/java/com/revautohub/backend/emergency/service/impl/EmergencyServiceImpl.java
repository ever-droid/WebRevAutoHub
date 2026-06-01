package com.revautohub.backend.emergency.service.impl;

import com.revautohub.backend.emergency.dto.AssignMechanicDTO;
import com.revautohub.backend.emergency.dto.EmergencyRequestDTO;
import com.revautohub.backend.emergency.dto.EmergencyResponseDTO;
import com.revautohub.backend.emergency.entity.EmergencyRequest;
import com.revautohub.backend.emergency.repository.EmergencyRepository;
import com.revautohub.backend.emergency.service.EmergencyService;
import com.revautohub.backend.mechanic.entity.Mechanic;
import com.revautohub.backend.mechanic.repository.MechanicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyServiceImpl implements EmergencyService {

    private final EmergencyRepository emergencyRepository;
    private final MechanicRepository mechanicRepository;

    public EmergencyServiceImpl(
            EmergencyRepository emergencyRepository,
            MechanicRepository mechanicRepository
    ) {
        this.emergencyRepository = emergencyRepository;
        this.mechanicRepository = mechanicRepository;
    }

    @Override
    public EmergencyResponseDTO createEmergencyRequest(EmergencyRequestDTO requestDTO) {

        EmergencyRequest emergencyRequest = new EmergencyRequest(
                requestDTO.getCustomerName(),
                requestDTO.getPhoneNumber(),
                requestDTO.getCarModel(),
                requestDTO.getProblemDescription(),
                requestDTO.getLatitude(),
                requestDTO.getLongitude()
        );

        EmergencyRequest savedRequest = emergencyRepository.save(emergencyRequest);

        return mapToResponseDTO(savedRequest);
    }

    @Override
    public List<EmergencyResponseDTO> getAllEmergencyRequests() {
        return emergencyRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    public EmergencyResponseDTO assignMechanic(Long emergencyId, AssignMechanicDTO assignMechanicDTO) {

        EmergencyRequest emergencyRequest = emergencyRepository.findById(emergencyId)
                .orElseThrow(() -> new RuntimeException("Emergency request not found"));

        Mechanic mechanic = mechanicRepository.findById(assignMechanicDTO.getMechanicId())
                .orElseThrow(() -> new RuntimeException("Mechanic not found"));

        emergencyRequest.setAssignedMechanicId(mechanic.getId());
        emergencyRequest.setAssignedMechanicName(mechanic.getFullName());
        emergencyRequest.setAssignedMechanicPhone(mechanic.getPhoneNumber());
        emergencyRequest.setAssignedMechanicLocation(mechanic.getLocation());
        emergencyRequest.setStatus("ASSIGNED");

        mechanic.setAvailabilityStatus("UNAVAILABLE");

        mechanicRepository.save(mechanic);
        EmergencyRequest savedRequest = emergencyRepository.save(emergencyRequest);

        return mapToResponseDTO(savedRequest);
    }

    @Override
    public EmergencyResponseDTO updateEmergencyStatus(Long id, String status) {

        EmergencyRequest emergencyRequest = emergencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emergency request not found"));

        emergencyRequest.setStatus(status);

        EmergencyRequest updatedRequest = emergencyRepository.save(emergencyRequest);

        return mapToResponseDTO(updatedRequest);
    }

    @Override
    public EmergencyResponseDTO getEmergencyById(Long id) {

        EmergencyRequest emergencyRequest = emergencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emergency request not found"));

        return mapToResponseDTO(emergencyRequest);
    }

    private EmergencyResponseDTO mapToResponseDTO(EmergencyRequest emergencyRequest) {
        return new EmergencyResponseDTO(
                emergencyRequest.getId(),
                emergencyRequest.getCustomerName(),
                emergencyRequest.getPhoneNumber(),
                emergencyRequest.getCarModel(),
                emergencyRequest.getProblemDescription(),
                emergencyRequest.getLatitude(),
                emergencyRequest.getLongitude(),
                emergencyRequest.getStatus(),
                emergencyRequest.getCreatedAt(),
                emergencyRequest.getAssignedMechanicId(),
                emergencyRequest.getAssignedMechanicName(),
                emergencyRequest.getAssignedMechanicPhone(),
                emergencyRequest.getAssignedMechanicLocation()
        );
    }
}
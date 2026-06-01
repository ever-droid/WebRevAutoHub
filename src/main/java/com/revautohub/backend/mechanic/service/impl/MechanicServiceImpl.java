package com.revautohub.backend.mechanic.service.impl;

import com.revautohub.backend.mechanic.dto.MechanicRequestDTO;
import com.revautohub.backend.mechanic.dto.MechanicResponseDTO;
import com.revautohub.backend.mechanic.entity.Mechanic;
import com.revautohub.backend.mechanic.repository.MechanicRepository;
import com.revautohub.backend.mechanic.service.MechanicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MechanicServiceImpl implements MechanicService {

    private final MechanicRepository mechanicRepository;

    public MechanicServiceImpl(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    @Override
    public MechanicResponseDTO createMechanic(MechanicRequestDTO requestDTO) {

        Mechanic mechanic = new Mechanic();

        mechanic.setFullName(requestDTO.getFullName());
        mechanic.setPhoneNumber(requestDTO.getPhoneNumber());
        mechanic.setSpecialization(requestDTO.getSpecialization());
        mechanic.setLocation(requestDTO.getLocation());

        if (requestDTO.getAvailabilityStatus() == null || requestDTO.getAvailabilityStatus().isEmpty()) {
            mechanic.setAvailabilityStatus("AVAILABLE");
        } else {
            mechanic.setAvailabilityStatus(requestDTO.getAvailabilityStatus());
        }

        Mechanic savedMechanic = mechanicRepository.save(mechanic);

        return mapToResponseDTO(savedMechanic);
    }

    @Override
    public List<MechanicResponseDTO> getAllMechanics() {
        return mechanicRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    public List<MechanicResponseDTO> getAvailableMechanics() {
        return mechanicRepository.findByAvailabilityStatus("AVAILABLE")
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    private MechanicResponseDTO mapToResponseDTO(Mechanic mechanic) {
        return new MechanicResponseDTO(
                mechanic.getId(),
                mechanic.getFullName(),
                mechanic.getPhoneNumber(),
                mechanic.getSpecialization(),
                mechanic.getLocation(),
                mechanic.getAvailabilityStatus()
        );
    }
}
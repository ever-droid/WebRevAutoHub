package com.revautohub.backend.mechanic.service;

import com.revautohub.backend.mechanic.dto.MechanicRequestDTO;
import com.revautohub.backend.mechanic.dto.MechanicResponseDTO;

import java.util.List;

public interface MechanicService {

    MechanicResponseDTO createMechanic(MechanicRequestDTO requestDTO);

    List<MechanicResponseDTO> getAllMechanics();

    List<MechanicResponseDTO> getAvailableMechanics();
}
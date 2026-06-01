package com.revautohub.backend.mechanic.controller;

import com.revautohub.backend.mechanic.dto.MechanicRequestDTO;
import com.revautohub.backend.mechanic.dto.MechanicResponseDTO;
import com.revautohub.backend.mechanic.service.MechanicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mechanics")
@CrossOrigin(origins = "*")
public class MechanicController {

    private final MechanicService mechanicService;

    public MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @PostMapping
    public ResponseEntity<MechanicResponseDTO> createMechanic(@RequestBody MechanicRequestDTO requestDTO) {
        MechanicResponseDTO mechanic = mechanicService.createMechanic(requestDTO);
        return new ResponseEntity<>(mechanic, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MechanicResponseDTO>> getAllMechanics() {
        return ResponseEntity.ok(mechanicService.getAllMechanics());
    }

    @GetMapping("/available")
    public ResponseEntity<List<MechanicResponseDTO>> getAvailableMechanics() {
        return ResponseEntity.ok(mechanicService.getAvailableMechanics());
    }
}
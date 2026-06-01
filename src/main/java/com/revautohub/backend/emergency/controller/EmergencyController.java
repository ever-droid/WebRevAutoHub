package com.revautohub.backend.emergency.controller;

import com.revautohub.backend.emergency.dto.AssignMechanicDTO;
import com.revautohub.backend.emergency.dto.EmergencyRequestDTO;
import com.revautohub.backend.emergency.dto.EmergencyResponseDTO;
import com.revautohub.backend.emergency.service.EmergencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergency")
public class EmergencyController {
    private final EmergencyService emergencyService;

    public EmergencyController(EmergencyService emergencyService){
        this.emergencyService = emergencyService;
    }

    @PostMapping
    public ResponseEntity<EmergencyResponseDTO> createEmergencyRequest(
            @RequestBody EmergencyRequestDTO emergencyRequestDTO){

        EmergencyResponseDTO response =
                emergencyService.createEmergencyRequest(emergencyRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmergencyResponseDTO>> getAllEmergencyRequests() {

        List<EmergencyResponseDTO> requests =
                emergencyService.getAllEmergencyRequests();

        return ResponseEntity.ok(requests);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<EmergencyResponseDTO> updateEmergencyStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        EmergencyResponseDTO response =
                emergencyService.updateEmergencyStatus(id, status);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/assign")
    public ResponseEntity<EmergencyResponseDTO> assignMechanic(
            @PathVariable Long id,
            @RequestBody AssignMechanicDTO assignMechanicDTO
    ) {

        return ResponseEntity.ok(
                emergencyService.assignMechanic(id, assignMechanicDTO)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyResponseDTO> getEmergencyById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                emergencyService.getEmergencyById(id)
        );
    }


}

package com.revautohub.backend.admin.controller;


import com.revautohub.backend.admin.dto.AssignMechanicRequestDTO;
import com.revautohub.backend.admin.dto.AssignMechanicResponseDTO;
import com.revautohub.backend.admin.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    // Service used to handle admin business logic
    private final AdminService adminService;

    // Constructor injection
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Receive mechanic assignment details from admin,
    // send them to service for processing,
    // and return assignment response
    @PostMapping("/assign-mechanic")
    public ResponseEntity<AssignMechanicResponseDTO> assignMechanic(
            @RequestBody AssignMechanicRequestDTO assignMechanicRequestDTO) {

        AssignMechanicResponseDTO responseDTO =
                adminService.assignMechanic(assignMechanicRequestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}

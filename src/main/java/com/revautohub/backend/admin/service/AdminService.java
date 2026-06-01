package com.revautohub.backend.admin.service;

import com.revautohub.backend.admin.dto.AssignMechanicRequestDTO;
import com.revautohub.backend.admin.dto.AssignMechanicResponseDTO;

public interface AdminService {
    // Receive mechanic assignment details from admin,
    // assign the mechanic to an emergency request,
    // and return the assignment response
    AssignMechanicResponseDTO assignMechanic(
            AssignMechanicRequestDTO assignMechanicRequestDTO
    );
}

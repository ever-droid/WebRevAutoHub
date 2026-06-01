package com.revautohub.backend.emergency.repository;

import com.revautohub.backend.emergency.entity.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRepository extends JpaRepository<EmergencyRequest, Long> {


}

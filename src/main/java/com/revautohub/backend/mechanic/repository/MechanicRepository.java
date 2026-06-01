package com.revautohub.backend.mechanic.repository;

import com.revautohub.backend.mechanic.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

    List<Mechanic> findByAvailabilityStatus(String availabilityStatus);
}
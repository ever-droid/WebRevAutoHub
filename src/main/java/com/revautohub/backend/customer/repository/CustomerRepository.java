package com.revautohub.backend.customer.repository;

import com.revautohub.backend.user.Role;
import com.revautohub.backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String Email);

    boolean existsByEmail(String Email);

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findByIdAndRole(Long id, Role role);
}

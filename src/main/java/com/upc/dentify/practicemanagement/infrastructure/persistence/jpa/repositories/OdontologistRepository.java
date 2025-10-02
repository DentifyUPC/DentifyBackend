package com.upc.dentify.practicemanagement.infrastructure.persistence.jpa.repositories;

import com.upc.dentify.practicemanagement.domain.model.aggregates.Odontologist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OdontologistRepository extends JpaRepository<Odontologist, Long> {
    List<Odontologist> findByClinicId(Long clinicId);
    Optional<Odontologist> findByUserId(Long userId);
}

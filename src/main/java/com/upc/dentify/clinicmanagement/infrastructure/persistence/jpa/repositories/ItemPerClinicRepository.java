package com.upc.dentify.clinicmanagement.infrastructure.persistence.jpa.repositories;

import com.upc.dentify.clinicmanagement.domain.model.aggregates.ItemPerClinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemPerClinicRepository extends JpaRepository<ItemPerClinic, Long> {
    Boolean existsByClinicIdAndItemId(Long clinicId, Long itemId);
}

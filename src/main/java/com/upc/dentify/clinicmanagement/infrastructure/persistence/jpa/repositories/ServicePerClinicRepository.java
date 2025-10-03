package com.upc.dentify.clinicmanagement.infrastructure.persistence.jpa.repositories;

import com.upc.dentify.clinicmanagement.domain.model.aggregates.ServicesPerClinics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicePerClinicRepository extends JpaRepository<ServicesPerClinics, Long> {
}

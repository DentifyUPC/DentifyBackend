package com.upc.dentify.clinicmanagement.infrastructure.persistence.jpa.repositories;

import com.upc.dentify.clinicmanagement.domain.model.aggregates.ItemPerClinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPerClinicRepository extends JpaRepository<ItemPerClinic, Long> {
    Boolean existsByClinicIdAndItemId(Long clinicId, Long itemId);

    @Query("SELECT ipc FROM ItemPerClinic ipc " +
            "JOIN FETCH ipc.item " +
            "JOIN FETCH ipc.clinic " +
            "WHERE ipc.clinic.id = :clinicId")
    List<ItemPerClinic> findAllByClinicId(@Param("clinicId") Long clinicId);
}

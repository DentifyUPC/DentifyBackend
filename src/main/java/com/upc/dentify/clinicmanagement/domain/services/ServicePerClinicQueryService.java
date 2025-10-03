package com.upc.dentify.clinicmanagement.domain.services;

public interface ServicePerClinicQueryService {
    boolean existsByClinicIdAndServiceId(Long clinicId, Long serviceId);
}

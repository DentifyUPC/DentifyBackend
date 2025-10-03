package com.upc.dentify.clinicmanagement.interfaces.acl;

public interface ServicePerClinicContextFacade {
    boolean existsByClinicIdAndServiceId(Long clinicId, Long serviceId);
}

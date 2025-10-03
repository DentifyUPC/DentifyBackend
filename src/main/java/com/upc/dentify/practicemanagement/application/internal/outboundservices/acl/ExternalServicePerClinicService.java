package com.upc.dentify.practicemanagement.application.internal.outboundservices.acl;

import com.upc.dentify.clinicmanagement.interfaces.acl.ServicePerClinicContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalServicePerClinicService {
    private final ServicePerClinicContextFacade servicePerClinicContextFacade;

    public ExternalServicePerClinicService(ServicePerClinicContextFacade servicePerClinicContextFacade) {
        this.servicePerClinicContextFacade = servicePerClinicContextFacade;
    }

    public boolean existsByClinicIdAndServiceId(Long clinicId, Long serviceId) {
        return servicePerClinicContextFacade.existsByClinicIdAndServiceId(clinicId, serviceId);
    }
}

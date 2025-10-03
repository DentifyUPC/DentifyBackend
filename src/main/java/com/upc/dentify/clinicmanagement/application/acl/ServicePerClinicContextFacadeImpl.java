package com.upc.dentify.clinicmanagement.application.acl;

import com.upc.dentify.clinicmanagement.domain.services.ServicePerClinicQueryService;
import com.upc.dentify.clinicmanagement.interfaces.acl.ServicePerClinicContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ServicePerClinicContextFacadeImpl implements ServicePerClinicContextFacade {
    private final ServicePerClinicQueryService servicePerClinicQueryService;

    public ServicePerClinicContextFacadeImpl(ServicePerClinicQueryService servicePerClinicQueryService) {
        this.servicePerClinicQueryService = servicePerClinicQueryService;
    }

    @Override
    public boolean existsByClinicIdAndServiceId(Long clinicId, Long serviceId) {
        return servicePerClinicQueryService.existsByClinicIdAndServiceId(clinicId, serviceId);
    }
}

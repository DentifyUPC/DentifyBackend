package com.upc.dentify.practicemanagement.application.internal.outboundservices.acl;

import com.upc.dentify.services.interfaces.acl.ServiceContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalServiceBoundedService {

    private final ServiceContextFacade serviceContextFacade;

    public ExternalServiceBoundedService(ServiceContextFacade serviceContextFacade) {
        this.serviceContextFacade = serviceContextFacade;
    }

    public boolean existsById(Long serviceId) { return serviceContextFacade.existsById(serviceId); }
}

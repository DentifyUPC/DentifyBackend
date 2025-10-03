package com.upc.dentify.services.application.acl;

import com.upc.dentify.services.domain.services.ServiceQueryService;
import com.upc.dentify.services.interfaces.acl.ServiceContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ServiceContextFacadeImpl implements ServiceContextFacade {
    private final ServiceQueryService serviceQueryService;

    public ServiceContextFacadeImpl(ServiceQueryService serviceQueryService) {
        this.serviceQueryService = serviceQueryService;
    }

    @Override
    public boolean existsById(Long serviceId) {
        return serviceQueryService.existsById(serviceId);
    }
}

package com.upc.dentify.services.application.internal.queryservices;

import com.upc.dentify.iam.infrastructure.security.AuthenticatedUserProvider;
import com.upc.dentify.services.domain.model.queries.GetAllServicesQuery;
import com.upc.dentify.services.domain.services.ServiceQueryService;
import com.upc.dentify.services.infrastructure.persistence.jpa.repositories.ServiceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceQueryServiceImpl implements ServiceQueryService {

    private final ServiceRepository serviceRepository;
    private final AuthenticatedUserProvider authenticatedUserProvider;

    public ServiceQueryServiceImpl(ServiceRepository serviceRepository,
                                   AuthenticatedUserProvider authenticatedUserProvider) {
        this.serviceRepository = serviceRepository;
        this.authenticatedUserProvider = authenticatedUserProvider;
    }

    @Override
    public List<com.upc.dentify.services.domain.model.aggregates.Service> handle(GetAllServicesQuery query) {
        return serviceRepository.findAll();
    }
}

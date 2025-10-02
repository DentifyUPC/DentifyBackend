package com.upc.dentify.services.interfaces.rest.assemblers;

import com.upc.dentify.services.domain.model.aggregates.Service;
import com.upc.dentify.services.interfaces.rest.dtos.ServiceResource;

public class ServiceResourceFromEntityAssembler {

    public static ServiceResource toResourceFromEntity(Service entity) {
        return new ServiceResource(entity.getId(), entity.getName());
    }
}

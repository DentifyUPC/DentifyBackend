package com.upc.dentify.services.domain.services;

import com.upc.dentify.services.domain.model.aggregates.Service;
import com.upc.dentify.services.domain.model.queries.GetAllServicesQuery;

import java.util.List;

public interface ServiceQueryService {
    List<Service> handle(GetAllServicesQuery query);
}

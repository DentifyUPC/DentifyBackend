package com.upc.dentify.services.domain.model.queries;

public record GetAllItemsRequiredByServiceIdQuery(Long serviceId) {

    public GetAllItemsRequiredByServiceIdQuery{
        if (serviceId == null ||  serviceId <= 0) {
            throw new IllegalArgumentException("Service id cannot  be null or less than zero");
        }
    }
}

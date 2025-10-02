package com.upc.dentify.services.domain.services;

import com.upc.dentify.services.domain.model.queries.GetAllItemsRequiredByServiceIdQuery;
import com.upc.dentify.services.interfaces.rest.dtos.ItemRequiredResource;

import java.util.List;

public interface ItemPerServiceQueryService {
    List<ItemRequiredResource> handle(GetAllItemsRequiredByServiceIdQuery query);
}

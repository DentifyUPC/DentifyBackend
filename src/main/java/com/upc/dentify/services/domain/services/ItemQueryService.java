package com.upc.dentify.services.domain.services;

import com.upc.dentify.services.domain.model.aggregates.Item;
import com.upc.dentify.services.domain.model.queries.GetAllItemsQuery;
import com.upc.dentify.services.domain.model.queries.GetItemByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ItemQueryService {
    List<Item> handle(GetAllItemsQuery query);
    Optional<Item> handle(GetItemByIdQuery query);
}

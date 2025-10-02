package com.upc.dentify.services.domain.services;

import com.upc.dentify.services.domain.model.aggregates.Item;
import com.upc.dentify.services.domain.model.queries.GetAllItemsQuery;

import java.util.List;

public interface ItemQueryService {
    List<Item> handle(GetAllItemsQuery query);
}

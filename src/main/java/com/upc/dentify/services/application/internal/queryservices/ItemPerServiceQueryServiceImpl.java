package com.upc.dentify.services.application.internal.queryservices;

import com.upc.dentify.services.domain.model.queries.GetAllItemsRequiredByServiceQuery;
import com.upc.dentify.services.domain.services.ItemPerServiceQueryService;
import com.upc.dentify.services.infrastructure.persistence.jpa.repositories.ItemPerServiceRepository;
import com.upc.dentify.services.interfaces.rest.dtos.ItemRequiredResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPerServiceQueryServiceImpl implements ItemPerServiceQueryService {

    private final ItemPerServiceRepository itemPerServiceRepository;

    public ItemPerServiceQueryServiceImpl(ItemPerServiceRepository itemPerServiceRepository) {
        this.itemPerServiceRepository = itemPerServiceRepository;
    }

    @Override
    public List<ItemRequiredResource> handle(GetAllItemsRequiredByServiceQuery query) {
        return itemPerServiceRepository.findAllItemsByServiceId(query.serviceId());
    }
}

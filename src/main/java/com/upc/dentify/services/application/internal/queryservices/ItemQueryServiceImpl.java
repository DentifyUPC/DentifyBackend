package com.upc.dentify.services.application.internal.queryservices;

import com.upc.dentify.services.domain.model.aggregates.Item;
import com.upc.dentify.services.domain.model.queries.GetAllItemsQuery;
import com.upc.dentify.services.domain.services.ItemQueryService;
import com.upc.dentify.services.infrastructure.persistence.jpa.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemQueryServiceImpl implements ItemQueryService {

    private final ItemRepository itemRepository;

    public ItemQueryServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> handle(GetAllItemsQuery query) {
        return itemRepository.findAll();
    }
}

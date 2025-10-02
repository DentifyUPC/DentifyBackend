package com.upc.dentify.services.application.acl;

import com.upc.dentify.services.domain.model.queries.GetItemByIdQuery;
import com.upc.dentify.services.domain.services.ItemQueryService;
import com.upc.dentify.services.interfaces.acl.ItemsContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ItemsContextFacadeImpl implements ItemsContextFacade {

    private final ItemQueryService itemQueryService;

    public ItemsContextFacadeImpl(ItemQueryService itemQueryService) {
        this.itemQueryService = itemQueryService;
    }

    @Override
    public Boolean existsById(Long id) {
        var item = itemQueryService.handle(new GetItemByIdQuery(id));
        return item.isPresent();
    }
}

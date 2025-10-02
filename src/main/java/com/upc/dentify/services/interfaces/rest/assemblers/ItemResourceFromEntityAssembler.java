package com.upc.dentify.services.interfaces.rest.assemblers;

import com.upc.dentify.services.domain.model.aggregates.Item;
import com.upc.dentify.services.interfaces.rest.dtos.ItemResource;

public class ItemResourceFromEntityAssembler {

    public static ItemResource toResourceFromEntity(Item entity) {
        return new ItemResource(entity.getId(), entity.getName(), entity.getUnitType().getName());
    }
}

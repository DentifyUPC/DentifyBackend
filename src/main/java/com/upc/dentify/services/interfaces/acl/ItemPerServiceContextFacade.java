package com.upc.dentify.services.interfaces.acl;

import com.upc.dentify.services.interfaces.rest.dtos.ItemRequiredResource;

import java.util.List;

public interface ItemPerServiceContextFacade {
    List<ItemRequiredResource> getItemIdsByServiceId(Long serviceId);
}

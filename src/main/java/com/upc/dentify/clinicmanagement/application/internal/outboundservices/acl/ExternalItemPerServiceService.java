package com.upc.dentify.clinicmanagement.application.internal.outboundservices.acl;

import com.upc.dentify.services.interfaces.acl.ItemPerServiceContextFacade;
import com.upc.dentify.services.interfaces.rest.dtos.ItemRequiredResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalItemPerServiceService {
    private final ItemPerServiceContextFacade itemPerServiceContextFacade;

    public ExternalItemPerServiceService(ItemPerServiceContextFacade itemPerServiceContextFacade) {
        this.itemPerServiceContextFacade = itemPerServiceContextFacade;
    }

    public List<ItemRequiredResource> getItemsIdsByServiceId(Long serviceId) {
        return itemPerServiceContextFacade.getItemIdsByServiceId(serviceId);
    }
}

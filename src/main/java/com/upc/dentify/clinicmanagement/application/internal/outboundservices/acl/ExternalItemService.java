package com.upc.dentify.clinicmanagement.application.internal.outboundservices.acl;

import com.upc.dentify.services.interfaces.acl.ItemsContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalItemService {

    private final ItemsContextFacade itemsContextFacade;

    public ExternalItemService(ItemsContextFacade itemsContextFacade) {
        this.itemsContextFacade = itemsContextFacade;
    }

    public Boolean existsById(Long id) {
        return itemsContextFacade.existsById(id);
    }
}

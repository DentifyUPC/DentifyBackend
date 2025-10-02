package com.upc.dentify.clinicmanagement.interfaces.rest.assemblers;

import com.upc.dentify.clinicmanagement.domain.model.aggregates.ItemPerClinic;
import com.upc.dentify.clinicmanagement.interfaces.rest.dtos.ItemPerClinicResource;

public class ItemPerClinicResourceFromEntityAssembler {

    public static ItemPerClinicResource toResourceFromEntity(ItemPerClinic entity) {
        return new ItemPerClinicResource(entity.getId(),
                entity.getAvailableStock(),
                entity.getMinimumStock(),
                entity.getPrice(),
                entity.getItem().getId(),
                entity.getClinic().getId());
    }

}

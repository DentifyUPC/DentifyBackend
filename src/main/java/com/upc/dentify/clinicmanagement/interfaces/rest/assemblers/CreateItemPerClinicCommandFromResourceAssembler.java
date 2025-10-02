package com.upc.dentify.clinicmanagement.interfaces.rest.assemblers;

import com.upc.dentify.clinicmanagement.domain.model.commands.CreateItemPerClinicCommand;
import com.upc.dentify.clinicmanagement.interfaces.rest.dtos.CreateItemPerClinicResource;

public class CreateItemPerClinicCommandFromResourceAssembler {

    public static CreateItemPerClinicCommand toCommandFromResource(CreateItemPerClinicResource resource) {
        return new CreateItemPerClinicCommand(resource.availableStock(),
                resource.minimumStock(),
                resource.price(),
                resource.itemId(),
                resource.clinicId());
    }
}

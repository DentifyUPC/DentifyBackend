package com.upc.dentify.clinicmanagement.interfaces.rest.assemblers;

import com.upc.dentify.clinicmanagement.domain.model.commands.CreateServicePerClinicCommand;
import com.upc.dentify.clinicmanagement.interfaces.rest.dtos.CreateServicePerClinicResource;

public class CreateServicePerClinicCommandFromResourceAssembler {
    public static CreateServicePerClinicCommand toCommandFromResource(CreateServicePerClinicResource resource) {
        return new CreateServicePerClinicCommand(
                resource.clinicId(),
                resource.serviceId(),
                resource.totalLaborPrice()
        );
    }
}

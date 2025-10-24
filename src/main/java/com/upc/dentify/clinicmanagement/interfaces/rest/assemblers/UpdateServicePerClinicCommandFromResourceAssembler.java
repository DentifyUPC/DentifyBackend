package com.upc.dentify.clinicmanagement.interfaces.rest.assemblers;

import com.upc.dentify.clinicmanagement.domain.model.commands.UpdateServicePerClinicCommand;
import com.upc.dentify.clinicmanagement.interfaces.rest.dtos.UpdateServicePerClinicResource;

public class UpdateServicePerClinicCommandFromResourceAssembler {
    public static UpdateServicePerClinicCommand toCommandFromResource(Long id, UpdateServicePerClinicResource resource) {
        return new UpdateServicePerClinicCommand(id, resource.totalLaborPrice());
    }
}

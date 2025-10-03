package com.upc.dentify.clinicmanagement.interfaces.rest.assemblers;

import com.upc.dentify.clinicmanagement.domain.model.commands.UpdateItemPerClinicCommand;
import com.upc.dentify.clinicmanagement.interfaces.rest.dtos.UpdateItemPerClinicResource;

public class UpdateItemPerClinicCommandFromResourceAssembler {

    public static UpdateItemPerClinicCommand toCommandFromResource(UpdateItemPerClinicResource resource, Long id) {
        return new UpdateItemPerClinicCommand(id, resource.availableStock(), resource.minimumStock(),
                resource.price());
    }

}

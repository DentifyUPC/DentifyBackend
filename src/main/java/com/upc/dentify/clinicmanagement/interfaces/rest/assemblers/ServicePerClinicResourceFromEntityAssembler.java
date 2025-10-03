package com.upc.dentify.clinicmanagement.interfaces.rest.assemblers;

import com.upc.dentify.clinicmanagement.domain.model.aggregates.ServicesPerClinics;
import com.upc.dentify.clinicmanagement.interfaces.rest.dtos.ServicePerClientResource;

public class ServicePerClinicResourceFromEntityAssembler {
    public static ServicePerClientResource toResourceFromEntity(ServicesPerClinics entity) {
        return new ServicePerClientResource(
                entity.getId(),
                entity.getClinicId(),
                entity.getServiceId(),
                entity.getTotalPricePerItems(),
                entity.getTotalLaborPrice(),
                entity.getTotalServicePrice()
        );
    }
}

package com.upc.dentify.clinicmanagement.domain.services;

import com.upc.dentify.clinicmanagement.domain.model.aggregates.ServicesPerClinics;
import com.upc.dentify.clinicmanagement.domain.model.commands.CreateServicePerClinicCommand;

import java.util.Optional;

public interface ServicePerClinicCommandService {
    Optional<ServicesPerClinics> handle(CreateServicePerClinicCommand command);
}

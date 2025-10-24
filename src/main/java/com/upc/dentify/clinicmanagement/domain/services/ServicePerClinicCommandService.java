package com.upc.dentify.clinicmanagement.domain.services;

import com.upc.dentify.clinicmanagement.domain.model.aggregates.ServicesPerClinics;
import com.upc.dentify.clinicmanagement.domain.model.commands.CreateServicePerClinicCommand;
import com.upc.dentify.clinicmanagement.domain.model.commands.UpdateServicePerClinicCommand;

import java.util.Optional;

public interface ServicePerClinicCommandService {
    Optional<ServicesPerClinics> handle(CreateServicePerClinicCommand command);
    Optional<ServicesPerClinics> handle(UpdateServicePerClinicCommand command);
}

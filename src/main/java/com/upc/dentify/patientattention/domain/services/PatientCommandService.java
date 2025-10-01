package com.upc.dentify.patientattention.domain.services;

import com.upc.dentify.patientattention.domain.model.aggregates.Patient;
import com.upc.dentify.patientattention.domain.model.commands.UpdatePatientCommand;

import java.util.Optional;

public interface PatientCommandService {
    Optional<Patient> handle(UpdatePatientCommand command);
}

package com.upc.dentify.patientattention.interfaces.rest.transform;

import com.upc.dentify.patientattention.domain.model.aggregates.Patient;
import com.upc.dentify.patientattention.interfaces.rest.resources.PatientResource;

public class PatientResourceFromEntityAssembler {
    public static PatientResource fromEntityToResource(Patient patient) {
        return new PatientResource(
                patient.getId(),
                patient.getPersonName().firstName(),
                patient.getPersonName().lastName(),
                patient.getEmail().email(),
                patient.getBirthDate().birthDate(),
                patient.getAge(),
                patient.getGender() != null ? patient.getGender().name() : null,
                patient.getAddress() != null ? patient.getAddress().street() : null,
                patient.getAddress() != null ? patient.getAddress().district() : null,
                patient.getAddress() != null ? patient.getAddress().province() : null,
                patient.getAddress() != null ? patient.getAddress().department() : null,
                patient.getPhoneNumber(),
                patient.getUserId()
        );
    }
}

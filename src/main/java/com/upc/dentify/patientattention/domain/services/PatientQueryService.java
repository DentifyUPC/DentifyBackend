package com.upc.dentify.patientattention.domain.services;

import com.upc.dentify.patientattention.domain.model.aggregates.Patient;
import com.upc.dentify.patientattention.domain.model.queries.GetAllPatientsByClinicId;
import com.upc.dentify.patientattention.domain.model.queries.GetPatientById;
import com.upc.dentify.patientattention.domain.model.queries.GetPatientByUserId;

import java.util.List;
import java.util.Optional;

public interface PatientQueryService {
    List<Patient> handle(GetAllPatientsByClinicId query);
    Optional<Patient> handle(GetPatientByUserId query);
    Optional<Patient> handle(GetPatientById query);
}

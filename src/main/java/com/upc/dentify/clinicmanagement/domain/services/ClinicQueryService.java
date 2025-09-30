package com.upc.dentify.clinicmanagement.domain.services;

import com.upc.dentify.clinicmanagement.domain.model.queries.GetAllClinicsInformationPreRegisterQuery;
import com.upc.dentify.clinicmanagement.interfaces.rest.dtos.ClinicInformationPreRegister;

import java.util.List;

public interface ClinicQueryService {
    List<ClinicInformationPreRegister> handle(GetAllClinicsInformationPreRegisterQuery query);
}

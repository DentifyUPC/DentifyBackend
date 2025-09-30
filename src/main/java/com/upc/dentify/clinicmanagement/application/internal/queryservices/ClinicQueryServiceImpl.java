package com.upc.dentify.clinicmanagement.application.internal.queryservices;

import com.upc.dentify.clinicmanagement.domain.model.queries.GetAllClinicsInformationPreRegisterQuery;
import com.upc.dentify.clinicmanagement.domain.services.ClinicQueryService;
import com.upc.dentify.clinicmanagement.infrastructure.persistence.jpa.repositories.ClinicRepository;
import com.upc.dentify.clinicmanagement.interfaces.rest.dtos.ClinicInformationPreRegister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicQueryServiceImpl implements ClinicQueryService {

    private final ClinicRepository clinicRepository;

    public ClinicQueryServiceImpl(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<ClinicInformationPreRegister> handle(GetAllClinicsInformationPreRegisterQuery query) {
        return clinicRepository.findAllClinicInformationPreRegister();
    }
}

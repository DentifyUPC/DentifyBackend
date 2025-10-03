package com.upc.dentify.clinicmanagement.domain.services;

import com.upc.dentify.clinicmanagement.domain.model.aggregates.ItemPerClinic;
import com.upc.dentify.clinicmanagement.domain.model.commands.CreateItemPerClinicCommand;
import com.upc.dentify.clinicmanagement.domain.model.commands.UpdateItemPerClinicCommand;

import java.util.Optional;

public interface ItemPerClinicCommandService {
    Optional<ItemPerClinic> handle(CreateItemPerClinicCommand command);
    Optional<ItemPerClinic> handle(UpdateItemPerClinicCommand command);
}

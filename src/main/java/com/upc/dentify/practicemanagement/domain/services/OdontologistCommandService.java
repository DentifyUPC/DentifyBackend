package com.upc.dentify.practicemanagement.domain.services;

import com.upc.dentify.practicemanagement.domain.model.aggregates.Odontologist;
import com.upc.dentify.practicemanagement.domain.model.commands.UpdateOdontologistCommand;

import java.util.Optional;

public interface OdontologistCommandService {
    Optional<Odontologist> handle(UpdateOdontologistCommand command);
}

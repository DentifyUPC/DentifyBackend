package com.upc.dentify.practicemanagement.application.internal.commandservices;

import com.upc.dentify.practicemanagement.domain.model.valueobjects.Address;
import com.upc.dentify.practicemanagement.application.internal.outboundservices.acl.ExternalServiceBoundedService;
import com.upc.dentify.practicemanagement.domain.model.aggregates.Odontologist;
import com.upc.dentify.practicemanagement.domain.model.commands.UpdateOdontologistCommand;
import com.upc.dentify.practicemanagement.domain.services.OdontologistCommandService;
import com.upc.dentify.practicemanagement.infrastructure.persistence.jpa.repositories.OdontologistRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OdontologistCommandServiceImpl implements OdontologistCommandService {
    private final OdontologistRepository odontologistRepository;
    private final ExternalServiceBoundedService externalServiceBoundedService;

    public OdontologistCommandServiceImpl(OdontologistRepository odontologistRepository, ExternalServiceBoundedService externalServiceBoundedService) {
        this.odontologistRepository = odontologistRepository;
        this.externalServiceBoundedService = externalServiceBoundedService;
    }


    @Override
    public Optional<Odontologist> handle(UpdateOdontologistCommand command) {
        if (command.serviceId() != null) {
            boolean exists = externalServiceBoundedService.existsById(command.serviceId());
            if (!exists) {
                throw new IllegalArgumentException("Service with ID " + command.serviceId() + " does not exist.");
            }
        }

        return odontologistRepository.findById(command.odontologistId())
                .map(odontologist -> {
                    Address address = null;
                    if (command.street() != null &&
                            command.department() != null &&
                            command.district() != null &&
                            command.province() != null) {
                        address = new Address(
                                command.street(),
                                command.district(),
                                command.department(),
                                command.province()
                        );
                    }

                    odontologist.updateAdditionalInformation(
                            command.gender(),
                            address,
                            command.phoneNumber(),
                            command.professionalLicenseNumber(),
                            command.specialtyRegistrationNumber(),
                            command.specialty(),
                            command.serviceId(),
                            command.isActive()
                    );
                    return odontologistRepository.save(odontologist);
                });
    }
}

package com.upc.dentify.practicemanagement.application.internal.commandservices;

import com.upc.dentify.practicemanagement.application.internal.outboundservices.acl.ExternalServicePerClinicService;
import com.upc.dentify.practicemanagement.domain.model.valueobjects.Address;
import com.upc.dentify.practicemanagement.domain.model.aggregates.Odontologist;
import com.upc.dentify.practicemanagement.domain.model.commands.UpdateOdontologistCommand;
import com.upc.dentify.practicemanagement.domain.services.OdontologistCommandService;
import com.upc.dentify.practicemanagement.infrastructure.persistence.jpa.repositories.OdontologistRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OdontologistCommandServiceImpl implements OdontologistCommandService {
    private final OdontologistRepository odontologistRepository;
    private final ExternalServicePerClinicService externalServicePerClinicService;

    public OdontologistCommandServiceImpl(OdontologistRepository odontologistRepository, ExternalServicePerClinicService externalServicePerClinicService) {
        this.odontologistRepository = odontologistRepository;
        this.externalServicePerClinicService = externalServicePerClinicService;
    }


    @Override
    public Optional<Odontologist> handle(UpdateOdontologistCommand command) {
        return odontologistRepository.findById(command.odontologistId())
                .map(odontologist -> {
                    if (command.serviceId() != null) {
                        Long clinicId = odontologist.getClinicId();
                        boolean exists = externalServicePerClinicService
                                .existsByClinicIdAndServiceId(clinicId, command.serviceId());

                        if (!exists) {
                            throw new IllegalArgumentException(
                                    "Service id " + command.serviceId() +
                                            " is not available in Clinic " + clinicId
                            );
                        }
                    }

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

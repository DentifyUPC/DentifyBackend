package com.upc.dentify.patientattention.application.internal.commandservices;

import com.upc.dentify.patientattention.domain.model.aggregates.Patient;
import com.upc.dentify.patientattention.domain.model.commands.UpdatePatientCommand;
import com.upc.dentify.patientattention.domain.model.valueobjects.Address;
import com.upc.dentify.patientattention.domain.services.PatientCommandService;
import com.upc.dentify.patientattention.infrastructure.persistence.jpa.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientCommandServiceImpl implements PatientCommandService {
    private final PatientRepository patientRepository;

    public PatientCommandServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Optional<Patient> handle(UpdatePatientCommand command) {
        return patientRepository.findById(command.patientId())
                .map(patient -> {
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

                    patient.updateAdditionalInfo(
                            command.gender(),
                            address,
                            command.phoneNumber()
                    );

                    return patientRepository.save(patient);
                });
    }
}

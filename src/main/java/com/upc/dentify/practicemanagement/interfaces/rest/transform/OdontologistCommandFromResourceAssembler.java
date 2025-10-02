package com.upc.dentify.practicemanagement.interfaces.rest.transform;

import com.upc.dentify.practicemanagement.domain.model.commands.UpdateOdontologistCommand;
import com.upc.dentify.practicemanagement.domain.model.valueobjects.Gender;
import com.upc.dentify.practicemanagement.interfaces.rest.resources.UpdateOdontologistRequestResource;

public class OdontologistCommandFromResourceAssembler {
    public static UpdateOdontologistCommand toCommand(Long odontologistId, UpdateOdontologistRequestResource request) {
        return new UpdateOdontologistCommand(
                odontologistId,
                Gender.valueOf(request.gender().toUpperCase()),
                request.street(),
                request.district(),
                request.department(),
                request.province(),
                request.phoneNumber(),
                request.professionalLicenseNumber(),
                request.specialtyRegistrationNumber(),
                request.specialty(),
                request.serviceId(),
                request.isActive()
        );
    }
}

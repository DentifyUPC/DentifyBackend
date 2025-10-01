package com.upc.dentify.patientattention.interfaces.rest.transform;

import com.upc.dentify.patientattention.domain.model.commands.UpdatePatientCommand;
import com.upc.dentify.patientattention.domain.model.valueobjects.Gender;
import com.upc.dentify.patientattention.interfaces.rest.resources.UpdatePatientRequestResource;

public class PatientCommandFromResourceAssembler {
    public static UpdatePatientCommand toCommand(Long patientId, UpdatePatientRequestResource request) {
        return new UpdatePatientCommand(
                patientId,
                Gender.valueOf(request.gender().toUpperCase()),
                request.street(),
                request.district(),
                request.department(),
                request.province(),
                request.phoneNumber()
        );
    }
}

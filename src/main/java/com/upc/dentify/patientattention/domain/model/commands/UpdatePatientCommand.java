package com.upc.dentify.patientattention.domain.model.commands;

import com.upc.dentify.patientattention.domain.model.valueobjects.Gender;

public record UpdatePatientCommand(
        Long patientId,
        Gender gender,
        String street,
        String district,
        String department,
        String province,
        String phoneNumber
) {
}

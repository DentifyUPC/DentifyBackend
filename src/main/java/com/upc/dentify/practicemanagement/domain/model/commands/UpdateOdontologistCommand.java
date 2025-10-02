package com.upc.dentify.practicemanagement.domain.model.commands;

import com.upc.dentify.practicemanagement.domain.model.valueobjects.Gender;

public record UpdateOdontologistCommand(
        Long odontologistId,
        Gender gender,
        String street,
        String district,
        String department,
        String province,
        String phoneNumber,
        String professionalLicenseNumber,
        String specialtyRegistrationNumber,
        String specialty,
        Long serviceId,
        boolean isActive
) {
}

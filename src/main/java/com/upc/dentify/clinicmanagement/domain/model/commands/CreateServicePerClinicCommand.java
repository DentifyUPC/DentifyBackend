package com.upc.dentify.clinicmanagement.domain.model.commands;

public record CreateServicePerClinicCommand(
        Long clinicId,
        Long serviceId,
        Double totalLaborPrice
) {
}

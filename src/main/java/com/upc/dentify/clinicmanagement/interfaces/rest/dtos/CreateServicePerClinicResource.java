package com.upc.dentify.clinicmanagement.interfaces.rest.dtos;

public record CreateServicePerClinicResource(
        Long clinicId,
        Long serviceId,
        Double totalLaborPrice
) {
}

package com.upc.dentify.patientattention.interfaces.rest.resources;

public record UpdatePatientRequestResource(
        String gender,
        String street,
        String district,
        String department,
        String province,
        String phoneNumber
) {
}

package com.upc.dentify.clinicmanagement.interfaces.rest.dtos;

public record UpdateItemPerClinicResource(Long availableStock,
                                          Long minimumStock,
                                          Double price) {
}

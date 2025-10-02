package com.upc.dentify.clinicmanagement.interfaces.rest.dtos;

public record CreateItemPerClinicResource(Long availableStock,
                                          Long minimumStock,
                                          Double price,
                                          Long itemId,
                                          Long clinicId) {
}

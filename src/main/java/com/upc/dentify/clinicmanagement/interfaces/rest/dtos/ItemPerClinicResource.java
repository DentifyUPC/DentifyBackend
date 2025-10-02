package com.upc.dentify.clinicmanagement.interfaces.rest.dtos;

public record ItemPerClinicResource(Long id,
                                    Long availableStock,
                                    Long minimumStock,
                                    Double price,
                                    Long itemId,
                                    Long clinicId) {
}

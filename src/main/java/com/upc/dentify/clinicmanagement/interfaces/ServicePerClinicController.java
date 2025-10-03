package com.upc.dentify.clinicmanagement.interfaces;

import com.upc.dentify.clinicmanagement.domain.services.ServicePerClinicCommandService;
import com.upc.dentify.clinicmanagement.interfaces.rest.assemblers.CreateServicePerClinicCommandFromResourceAssembler;
import com.upc.dentify.clinicmanagement.interfaces.rest.assemblers.ServicePerClinicResourceFromEntityAssembler;
import com.upc.dentify.clinicmanagement.interfaces.rest.dtos.CreateServicePerClinicResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "api/v1/services-per-clinics", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Services per clinics", description = "Services per Clinics Endpoint")
public class ServicePerClinicController {
    private final ServicePerClinicCommandService servicePerClinicCommandService;

    public ServicePerClinicController(ServicePerClinicCommandService servicePerClinicCommandService) {
        this.servicePerClinicCommandService = servicePerClinicCommandService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    @Operation(summary = "Create service per clinic", description = "Create a new service per clinic")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Clinic per clinic created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Clinic already exists in clinic"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<?> createServicePerClinic(@RequestBody CreateServicePerClinicResource resource) {
        try {
            var command = CreateServicePerClinicCommandFromResourceAssembler.toCommandFromResource(resource);
            var entity = servicePerClinicCommandService.handle(command);
            if (entity.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Unable to create service per clinic"));
            }
            var response = ServicePerClinicResourceFromEntityAssembler.toResourceFromEntity(entity.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Unexpected error: " + e.getMessage()));
        }
    }
}

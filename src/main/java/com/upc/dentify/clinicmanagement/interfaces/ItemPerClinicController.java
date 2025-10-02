package com.upc.dentify.clinicmanagement.interfaces;

import com.upc.dentify.clinicmanagement.domain.model.commands.CreateItemPerClinicCommand;
import com.upc.dentify.clinicmanagement.domain.services.ItemPerClinicCommandService;
import com.upc.dentify.clinicmanagement.interfaces.rest.assemblers.CreateItemPerClinicCommandFromResourceAssembler;
import com.upc.dentify.clinicmanagement.interfaces.rest.assemblers.ItemPerClinicResourceFromEntityAssembler;
import com.upc.dentify.clinicmanagement.interfaces.rest.dtos.CreateItemPerClinicResource;
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
@RequestMapping(value = "api/v1/items-per-clinics", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Items per clinics", description = "Items per Clinics Endpoint")
public class ItemPerClinicController {

    private final ItemPerClinicCommandService itemPerClinicCommandService;

    public ItemPerClinicController(ItemPerClinicCommandService itemPerClinicCommandService) {
        this.itemPerClinicCommandService = itemPerClinicCommandService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    @Operation(summary = "Create item per clinic", description = "Create a new item per clinic")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item per clinic created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Item already exists in clinic"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<?> createItemPerClinic(@RequestBody CreateItemPerClinicResource resource) {
        try {
            CreateItemPerClinicCommand command =
                    CreateItemPerClinicCommandFromResourceAssembler.toCommandFromResource(resource);

            var itemPerClinic = itemPerClinicCommandService.handle(command);

            if (itemPerClinic.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("error", "Unable to create ItemPerClinic"));
            }

            // convertir a DTO de salida
            var response = ItemPerClinicResourceFromEntityAssembler.toResourceFromEntity(itemPerClinic.get());

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

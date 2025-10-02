package com.upc.dentify.clinicmanagement.interfaces;

import com.upc.dentify.clinicmanagement.domain.services.ItemPerClinicCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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


}

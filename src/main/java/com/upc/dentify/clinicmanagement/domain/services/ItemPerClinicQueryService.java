package com.upc.dentify.clinicmanagement.domain.services;

import com.upc.dentify.clinicmanagement.domain.model.aggregates.ItemPerClinic;
import com.upc.dentify.clinicmanagement.domain.model.queries.GetAllItemsPerClinicIdQuery;

import java.util.List;

public interface ItemPerClinicQueryService {
    List<ItemPerClinic> handle(GetAllItemsPerClinicIdQuery query);
}

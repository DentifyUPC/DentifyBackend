package com.upc.dentify.clinicmanagement.application.internal.queryservices;

import com.upc.dentify.clinicmanagement.domain.model.aggregates.ItemPerClinic;
import com.upc.dentify.clinicmanagement.domain.model.queries.GetAllItemsPerClinicIdQuery;
import com.upc.dentify.clinicmanagement.domain.services.ItemPerClinicQueryService;
import com.upc.dentify.clinicmanagement.infrastructure.persistence.jpa.repositories.ItemPerClinicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPerClinicQueryServiceImpl implements ItemPerClinicQueryService {

    private final ItemPerClinicRepository itemPerClinicRepository;

    public ItemPerClinicQueryServiceImpl(ItemPerClinicRepository itemPerClinicRepository) {
        this.itemPerClinicRepository = itemPerClinicRepository;
    }

    @Override
    public List<ItemPerClinic> handle(GetAllItemsPerClinicIdQuery query) {
        return itemPerClinicRepository.findAllByClinicId(query.clinicId());
    }
}

package com.upc.dentify.clinicmanagement.application.internal.commandservices;

import com.upc.dentify.clinicmanagement.application.internal.outboundservices.acl.ExternalItemPerServiceService;
import com.upc.dentify.clinicmanagement.domain.model.aggregates.ItemPerClinic;
import com.upc.dentify.clinicmanagement.domain.model.aggregates.ServicesPerClinics;
import com.upc.dentify.clinicmanagement.domain.model.commands.CreateServicePerClinicCommand;
import com.upc.dentify.clinicmanagement.domain.services.ServicePerClinicCommandService;
import com.upc.dentify.clinicmanagement.infrastructure.persistence.jpa.repositories.ItemPerClinicRepository;
import com.upc.dentify.clinicmanagement.infrastructure.persistence.jpa.repositories.ServicePerClinicRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicePerClinicCommandServiceImpl implements ServicePerClinicCommandService {
    private final ServicePerClinicRepository servicePerClinicRepository;
    private final ExternalItemPerServiceService externalItemPerServiceService;
    private final ItemPerClinicRepository itemPerClinicRepository;

    public ServicePerClinicCommandServiceImpl(ServicePerClinicRepository servicePerClinicRepository, ExternalItemPerServiceService externalItemPerServiceService, ItemPerClinicRepository itemPerClinicRepository) {
        this.servicePerClinicRepository = servicePerClinicRepository;
        this.externalItemPerServiceService = externalItemPerServiceService;
        this.itemPerClinicRepository = itemPerClinicRepository;
    }


    @Override
    public Optional<ServicesPerClinics> handle(CreateServicePerClinicCommand command) {
        var requiredItems = externalItemPerServiceService.getItemsIdsByServiceId(command.serviceId());
        var clinicItems = itemPerClinicRepository.findAllByClinicId(command.clinicId());

        for (var requiredItem : requiredItems) {
            var clinicItem = clinicItems.stream()
                    .filter(ipc -> ipc.getItem().getId().equals(requiredItem.id()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            if (clinicItem.getAvailableStock() < requiredItem.quantityRequired()) {
                throw new IllegalArgumentException(
                        "Clinic " + command.clinicId() + " doesn't have enough stock"
                );
            }
        }

        double totalPricePerItems = requiredItems.stream()
                .mapToDouble(required -> {
                    var clinicItem = clinicItems.stream()
                            .filter(ipc -> ipc.getItem().getId().equals(required.id()))
                            .findFirst()
                            .get();
                    return clinicItem.getPrice() * required.quantityRequired();
                })
                .sum();

        var servicesPerClinics = new ServicesPerClinics(command.clinicId(), command.serviceId(), command.totalLaborPrice());
        servicesPerClinics.calculateTotals(totalPricePerItems);

        var saved = servicePerClinicRepository.save(servicesPerClinics);

        return Optional.of(saved);
    }
}

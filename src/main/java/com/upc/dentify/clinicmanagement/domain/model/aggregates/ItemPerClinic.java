package com.upc.dentify.clinicmanagement.domain.model.aggregates;

import com.upc.dentify.clinicmanagement.domain.model.commands.CreateItemPerClinicCommand;
import com.upc.dentify.services.domain.model.aggregates.Item;
import com.upc.dentify.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class ItemPerClinic extends AuditableAbstractAggregateRoot<ItemPerClinic> {

    @Min(0)
    @Column(nullable = false)
    private Long availableStock;

    @Min(1)
    @Column(nullable = false)
    private Long minimumStock;

    @Min(1)
    @Column(nullable = false)
    private Double price;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_id", nullable = false)
    private Clinic clinic;

    public ItemPerClinic() {}

    public ItemPerClinic(CreateItemPerClinicCommand command) {
        this.availableStock = command.availableStock();
        this.minimumStock = command.minimumStock();
        this.price = command.price();
        this.item = new Item(command.itemId());
        this.clinic = new Clinic(command.clinicId());
    }

    public Long getAvailableStock() {
        return availableStock;
    }

    public Long getMinimumStock() {
        return minimumStock;
    }

    public Double getPrice() {
        return price;
    }

    public Item getItem() {
        return item;
    }

    public Clinic getClinic() {
        return clinic;
    }
}

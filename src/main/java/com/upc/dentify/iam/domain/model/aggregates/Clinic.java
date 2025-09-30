package com.upc.dentify.iam.domain.model.aggregates;

import com.upc.dentify.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Clinic extends AuditableAbstractAggregateRoot<Clinic> {

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String ruc;

    @NotBlank
    @Column(nullable = false)
    private String address;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String phone;

    public Clinic() {}

    public Clinic(Long id) {
        setId(id);
    }
}

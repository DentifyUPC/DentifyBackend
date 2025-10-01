package com.upc.dentify.patientattention.domain.model.aggregates;

import com.upc.dentify.patientattention.domain.model.valueobjects.*;
import com.upc.dentify.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Patient extends AuditableAbstractAggregateRoot<Patient> {
    @Embedded
    @Column(nullable = false)
    private PersonName personName;

    @Embedded
    @Column(nullable = false)
    private BirthDate birthDate;

    @Embedded
    @Column(nullable = false)
    private Email email;

    @Enumerated(EnumType.STRING)
    @Embedded
    @Column
    private Gender gender;

    @Embedded
    @Column
    private Address address;

    @Size(min = 9)
    @Column
    private String phoneNumber;

    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Transient
    private Integer age;

    @Column(name = "clinic_id", nullable = false)
    private Long clinicId;

    public Patient() {}

    public Integer getAge() {
        if (birthDate != null) {
            return birthDate.calculateAge();
        }
        return null;
    }

    public Patient(Long userId, String firstName, String lastName, String birthDate, String email, Long  clinicId) {
        this.userId = userId;
        this.personName = new PersonName(firstName, lastName);
        this.birthDate = new BirthDate(birthDate);
        this.email = new Email(email);
        this.clinicId = clinicId;
    }

    public void updateAdditionalInfo(Gender gender, Address address, String phoneNumber) {
        if (gender != null) this.gender = gender;
        if (address != null) this.address = address;
        if (phoneNumber != null && !phoneNumber.isBlank()) this.phoneNumber = phoneNumber;
    }

    public PersonName getPersonName() {
        return personName;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }

    public Email getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Long getUserId() {
        return userId;
    }
}

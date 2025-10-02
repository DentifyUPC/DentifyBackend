package com.upc.dentify.practicemanagement.application.internal.eventhandlers;

import com.upc.dentify.iam.domain.events.UserCreatedEvent;
import com.upc.dentify.practicemanagement.domain.model.aggregates.Odontologist;
import com.upc.dentify.practicemanagement.infrastructure.persistence.jpa.repositories.OdontologistRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("practiceUserEventHandler")
public class UserEventHandler {

    private final OdontologistRepository odontologistRepository;

    private static final Long ODONTOLOGIST_ROLE_ID = 2L;

    public UserEventHandler(OdontologistRepository odontologistRepository) {
        this.odontologistRepository = odontologistRepository;
    }

    @EventListener
    public void handle(UserCreatedEvent event) {
        if (ODONTOLOGIST_ROLE_ID.equals(event.getRole())) {
            Odontologist odontologist = new Odontologist(
                    event.getUserId(),
                    event.getFirstName(),
                    event.getLastName(),
                    event.getBirthDate(),
                    event.getEmail(),
                    event.getClinicId()
            );
            odontologistRepository.save(odontologist);
        }
    }
}

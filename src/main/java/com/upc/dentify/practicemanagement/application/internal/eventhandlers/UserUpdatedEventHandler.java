package com.upc.dentify.practicemanagement.application.internal.eventhandlers;

import com.upc.dentify.iam.domain.events.UserUpdatedEvent;
import com.upc.dentify.practicemanagement.infrastructure.persistence.jpa.repositories.OdontologistRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service("practiceUserUpdatedEventHandler")
public class UserUpdatedEventHandler {
    private final OdontologistRepository odontologistRepository;

    public UserUpdatedEventHandler(OdontologistRepository odontologistRepository) {
        this.odontologistRepository = odontologistRepository;
    }

    @EventListener
    public void handle(UserUpdatedEvent event) {
        odontologistRepository.findByUserId(event.userId()).ifPresent(odontologist -> {
            odontologist.updateBasicInfo(
                    event.firstName(),
                    event.lastName(),
                    event.email(),
                    event.birthdate()
            );
            odontologistRepository.save(odontologist);
        });
    }
}

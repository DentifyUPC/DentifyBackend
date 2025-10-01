package com.upc.dentify.iam.application.internal.commandservices;

import com.upc.dentify.iam.domain.events.UserCreatedEvent;
import com.upc.dentify.iam.domain.model.aggregates.User;
import com.upc.dentify.iam.domain.model.commands.SignInCommand;
import com.upc.dentify.iam.domain.model.commands.SignUpCommand;
import com.upc.dentify.iam.domain.model.entities.IdentificationType;
import com.upc.dentify.iam.domain.model.valueobjects.Username;
import com.upc.dentify.iam.domain.services.AuthCommandService;
import com.upc.dentify.iam.domain.services.JwtService;
import com.upc.dentify.iam.infrastructure.persistence.jpa.repositories.IdentificationTypeRepository;
import com.upc.dentify.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.upc.dentify.iam.interfaces.rest.resources.AuthResponseResource;
import com.upc.dentify.iam.interfaces.rest.resources.RegisterResponseResource;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthCommandServiceImpl implements AuthCommandService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final IdentificationTypeRepository identificationTypeRepository;
    private final ApplicationEventPublisher eventPublisher;

    public AuthCommandServiceImpl(JwtService jwtService,
                                  UserRepository userRepository,
                                  BCryptPasswordEncoder passwordEncoder,
                                    IdentificationTypeRepository identificationTypeRepository,
                                  ApplicationEventPublisher eventPublisher) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.identificationTypeRepository = identificationTypeRepository;
        this.eventPublisher = eventPublisher;
    }

    public AuthResponseResource login(SignInCommand command) {
        User user = userRepository.findByUsername(new Username(command.username())).orElseThrow(() -> new UsernameNotFoundException("user not found"));

        if (!passwordEncoder.matches(command.password(), user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return new AuthResponseResource(
                accessToken,
                refreshToken,
                user.getId(),
                user.getUsername(),
                user.getRole().getId(),
                user.getClinic().getId());
    }

    @Override
    public RegisterResponseResource register(SignUpCommand command) {
        if (userRepository.findByUsername(new Username(command.username())).isPresent()) {
            throw new IllegalArgumentException("This username is already used");
        }

        String hashedPassword = passwordEncoder.encode(command.password());

        IdentificationType type = identificationTypeRepository.findById(command.identificationTypeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Identification Type"));

        var user = new User(command, hashedPassword, type);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new IllegalArgumentException("A error occurred while saving user" + e.getMessage());
        }

        System.out.println("Publicando UserCreatedEvent con roleId=" + command.roleId() + " y userId=" + user.getId());
        eventPublisher.publishEvent(new UserCreatedEvent(
                user.getId(),
                command.roleId(),
                user.getPersonName().firstName(),
                user.getPersonName().lastName(),
                user.getBirthDate().birthDate(),
                user.getEmail().email(),
                user.getClinic().getId()
        ));

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return new RegisterResponseResource(
                accessToken,
                refreshToken,
                user.getId(),
                user.getUsername(),
                user.getRole().getId(),
                user.getClinic().getId());
    }


}

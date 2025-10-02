package com.upc.dentify.iam.infrastructure.persistence.jpa.repositories;

import com.upc.dentify.iam.domain.model.aggregates.User;
import com.upc.dentify.iam.domain.model.queries.GetClinicIdByUserIdQuery;
import com.upc.dentify.iam.domain.model.valueobjects.Username;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(Username username);

    @Query("SELECT u.clinic.id FROM User u WHERE u.id = :userId")
    Long findClinicIdById(Long userId);
}
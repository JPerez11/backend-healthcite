package co.gov.heqc.healthcite.repositories;

import co.gov.heqc.healthcite.entities.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<PeopleEntity, Long> {

    Optional<PeopleEntity> findByEmail(String email);
    Optional<PeopleEntity> findByDocumentAndRoleName(String docuement, String role);
    boolean existsByDocument(String document);
    boolean existsByEmail(String email);
    Optional<PeopleEntity> findByEmailOrUsernameAndPassword(String email, String username, String password);
}

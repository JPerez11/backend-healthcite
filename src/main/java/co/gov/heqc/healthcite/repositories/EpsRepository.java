package co.gov.heqc.healthcite.repositories;

import co.gov.heqc.healthcite.entities.EpsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EpsRepository extends JpaRepository<EpsEntity, Long> {

    Optional<EpsEntity> findByNameIgnoreCase(String name);
    boolean existsByNit(String nit);
    Optional<EpsEntity> findByNit(String nit);

}

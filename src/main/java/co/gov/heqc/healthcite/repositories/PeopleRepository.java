package co.gov.heqc.healthcite.repositories;

import co.gov.heqc.healthcite.entities.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<PeopleEntity, Long> {
}

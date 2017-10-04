package pl.sportfacility.sportfacility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sportfacility.sportfacility.entity.EventType;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Long> {
}

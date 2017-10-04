package pl.sportfacility.sportfacility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sportfacility.sportfacility.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}

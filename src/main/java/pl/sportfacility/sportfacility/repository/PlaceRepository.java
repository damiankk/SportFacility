package pl.sportfacility.sportfacility.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sportfacility.sportfacility.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>{
}

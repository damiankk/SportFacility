package pl.sportfacility.sportfacility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sportfacility.sportfacility.entity.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {

    UserRoles findByUsername(final String username);
}

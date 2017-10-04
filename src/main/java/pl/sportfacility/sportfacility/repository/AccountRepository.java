package pl.sportfacility.sportfacility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sportfacility.sportfacility.entity.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findById(final Long id);

    Optional<Account> findByEmail(final String email);

    Optional<Account> findByUsername(final String username);
}

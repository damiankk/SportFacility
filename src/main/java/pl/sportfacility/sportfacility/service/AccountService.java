package pl.sportfacility.sportfacility.service;

import pl.sportfacility.sportfacility.dto.AccountDto;
import pl.sportfacility.sportfacility.entity.Account;

import java.util.List;

public interface AccountService {

    Long save(final AccountDto accountDto);

    Long delete(final Long id);

    AccountDto findByEmail(final String email);

    AccountDto findByUsername(final String username);

    List<AccountDto> findAllAccount();

    boolean changeRole(final AccountDto accountDto);

    Account findById(Long id);

}

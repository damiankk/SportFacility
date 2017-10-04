package pl.sportfacility.sportfacility.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sportfacility.sportfacility.dto.AccountDto;
import pl.sportfacility.sportfacility.entity.Account;
import pl.sportfacility.sportfacility.entity.UserRoles;
import pl.sportfacility.sportfacility.exception.AccountException;
import pl.sportfacility.sportfacility.exception.Error;
import pl.sportfacility.sportfacility.helper.AccountConverter;
import pl.sportfacility.sportfacility.repository.AccountRepository;
import pl.sportfacility.sportfacility.repository.UserRolesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountConverter accountConverter;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public AccountServiceImpl(final AccountRepository accountRepository, UserRolesRepository userRolesRepository) {
        this.accountRepository = accountRepository;
        this.userRolesRepository = userRolesRepository;
        this.accountConverter = new AccountConverter();
    }

    @Override
    public Long save(final AccountDto accountDto) {
        final UserRoles userRoles = UserRoles.builder()
                .username(accountDto.getUsername())//
                .role(accountDto.getRole())//
                .build();//
        if(accountDto.getUsername().equalsIgnoreCase("admin")){
            userRoles.setRole("ADMIN");
        }else{
            userRoles.setRole("USER");
        }

        userRolesRepository.save(userRoles);
        accountRepository.save(getEntity(accountDto));

        return accountDto.getId();
    }

    @Override
    public Long delete(final Long id) {
        accountRepository.delete(id);

        return id;
    }

    @Override
    public AccountDto findByEmail(final String email) {

        return accountRepository.findByEmail(email) //
                .map(this::getDto) //
                .orElseThrow(() -> new AccountException(Error.CANNOT_FIND_ACCOUNT_BY_EMAIL.getMessage()));
    }

    @Override
    public AccountDto findByUsername(final String username) {

        return accountRepository.findByUsername(username) //
                .map(this::getDto) //
                .orElseThrow(() -> new AccountException(Error.CANNOT_FIND_ACCOUNT_BY_USERNAME.getMessage()));
    }

    @Override
    public List<AccountDto> findAllAccount() {

        return accountRepository.findAll().stream()
                .map(this::getDto) //
                .collect(Collectors.toList());
    }

    @Override
    public boolean changeRole(final AccountDto accountDto) {
        final UserRoles userRoles = userRolesRepository.findByUsername(accountDto.getUsername());
        userRoles.setRole(accountDto.getRole());
        userRolesRepository.save(userRoles);

        return true;
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id);
    }

    private Account getEntity(final AccountDto accountDto) {
        return accountConverter.convertDtoToEntity(accountDto);
    }

    private AccountDto getDto(final Account account) {
        return accountConverter.convertEntityToDto(account);
    }
}

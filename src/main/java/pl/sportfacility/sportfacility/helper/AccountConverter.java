package pl.sportfacility.sportfacility.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sportfacility.sportfacility.dto.AccountDto;
import pl.sportfacility.sportfacility.entity.Account;
import pl.sportfacility.sportfacility.repository.UserRolesRepository;

@Component
public class AccountConverter {

    @Autowired
   private  UserRolesRepository userRolesRepository;

    public AccountConverter() {

    }

    public Account convertDtoToEntity(final AccountDto accountDto) {

        return Account.builder() //
                .id(accountDto.getId())
                .username(accountDto.getUsername())
                .name(accountDto.getName()) //
                .surname(accountDto.getSurname()) //
                .address(accountDto.getAddress()) //
                .phoneNumber(accountDto.getPhoneNumber()) //
                .email(accountDto.getEmail()) //
                .password(accountDto.getPassword()) //
                .enabled(true) //
                .build(); //
    }

    public AccountDto convertEntityToDto(final Account account) {


        return AccountDto.builder() //
                .id(account.getId()) //
                .username(account.getUsername())
                .name(account.getName()) //
                .surname(account.getSurname()) //
                .email(account.getEmail()) //
                .address(account.getAddress()) //
                .phoneNumber(account.getPhoneNumber()) //
                .build();
    }
}

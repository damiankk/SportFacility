package pl.sportfacility.sportfacility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.sportfacility.sportfacility.dto.AccountDto;
import pl.sportfacility.sportfacility.entity.Account;
import pl.sportfacility.sportfacility.entity.UserRoles;
import pl.sportfacility.sportfacility.helper.AccountConverter;
import pl.sportfacility.sportfacility.service.AccountServiceImpl;
import pl.sportfacility.sportfacility.service.UserRolesServiceImpl;


@RestController
@RequestMapping
public class LoginController {

    private final AccountServiceImpl accountService;
    private final AccountConverter accountConverter;
    private final UserRolesServiceImpl userRolesService;

    @Autowired
    public LoginController(AccountServiceImpl accountService, UserRolesServiceImpl userRolesService) {
        this.accountService = accountService;
        this.userRolesService = userRolesService;
        this.accountConverter = new AccountConverter();
    }

    @RequestMapping(path = "/unauthorized", method = RequestMethod.GET)
    public ResponseEntity<Void> login() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @RequestMapping(path = "/success", method = RequestMethod.GET)
    public ResponseEntity<AccountDto> success() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Account userAccount = accountConverter.convertDtoToEntity(accountService.findByUsername(authentication.getName()));
        final AccountDto userAccountDto = accountConverter.convertEntityToDto(userAccount);
        final UserRoles userRoles = userRolesService.findByUsername(userAccount.getUsername());
        userAccountDto.setRole(userRoles.getRole());

        return ResponseEntity.status(HttpStatus.OK).body(userAccountDto);
   }


}


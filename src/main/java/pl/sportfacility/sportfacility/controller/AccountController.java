package pl.sportfacility.sportfacility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sportfacility.sportfacility.dto.AccountDto;
import pl.sportfacility.sportfacility.service.AccountServiceImpl;
import pl.sportfacility.sportfacility.service.UserRolesServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class AccountController {

    private final AccountServiceImpl accountService;
    private final UserRolesServiceImpl userRolesService;

    @Autowired
    public AccountController(final AccountServiceImpl accountService, UserRolesServiceImpl userRolesService) {
        this.accountService = accountService;
        this.userRolesService = userRolesService;
    }

    @PostMapping("/register")
    public HttpEntity<Long> registerNewUser(@RequestBody final AccountDto accountDto) {
        accountService.save(accountDto);

        return new ResponseEntity<Long>(HttpStatus.CREATED); //
    }

    @DeleteMapping("/delete")
    public HttpEntity<Long> deleteUser(@RequestBody final AccountDto accountDto) {
        accountService.delete(accountDto.getId());

        return new ResponseEntity<Long>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<AccountDto> allUsers() {

        return accountService.findAllAccount();
    }

    @PostMapping("/find/email")
    public HttpEntity<AccountDto> findByEmail(@RequestBody final String email) {

        return new ResponseEntity<AccountDto>(HttpStatus.OK);
    }

    @PostMapping(value = "/find/username", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public AccountDto findByUsername(@RequestParam final String username) {

        return accountService.findByUsername(username);
    }

    @PostMapping(value = "/changeRole", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void changeRole(@RequestBody final AccountDto accountDto) {

        accountService.changeRole(accountDto);
    }


}

package pl.sportfacility.sportfacility.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {

    private Long id;
    private String username;
    private String password;
    private String confirmPassword;
    private String name;
    private String surname;
    private String email;
    private String address;
    private Integer phoneNumber;
    private String role;
}

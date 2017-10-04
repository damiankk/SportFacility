package pl.sportfacility.sportfacility.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;
    @Column(name = "username")
    @NotNull
    private String username;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "surname")
    @NotNull
    private String surname;
    @Column(name = "email")
    @NotNull
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @Column(name = "enabled")
    private Boolean enabled = true;
    @Tolerate
    public Account(){
    }
}

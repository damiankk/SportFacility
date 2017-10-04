package pl.sportfacility.sportfacility.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_role_id")
    private Long id;
    @NotNull
    @Column(name = "username")
    private String username;
    @NotNull
    @Column(name = "role")
    private String role;

    @Tolerate
    public UserRoles(){
    }
}

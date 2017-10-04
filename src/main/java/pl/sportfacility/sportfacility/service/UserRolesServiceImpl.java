package pl.sportfacility.sportfacility.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sportfacility.sportfacility.entity.UserRoles;
import pl.sportfacility.sportfacility.repository.UserRolesRepository;

@Service
public class UserRolesServiceImpl {

    private final UserRolesRepository userRolesRepository;

    @Autowired
    public UserRolesServiceImpl(UserRolesRepository userRolesRepository) {
        this.userRolesRepository = userRolesRepository;
    }

    public void save(final UserRoles userRoles){
        userRolesRepository.save(userRoles);
    }

    public UserRoles findByUsername(final String username){
        return userRolesRepository.findByUsername(username);
    }
}

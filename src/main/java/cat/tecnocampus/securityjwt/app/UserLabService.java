package cat.tecnocampus.securityjwt.app;

import cat.tecnocampus.securityjwt.app.dto.NewUserLabDto;
import cat.tecnocampus.securityjwt.app.dto.UserLabDto;
import cat.tecnocampus.securityjwt.domain.Role;
import cat.tecnocampus.securityjwt.domain.UserLab;
import cat.tecnocampus.securityjwt.persistence.RoleRepository;
import cat.tecnocampus.securityjwt.persistence.UserLabRepository;
import org.springframework.stereotype.Service;


@Service
public class UserLabService {

    private UserLabRepository userLabRepository;
    private RoleRepository roleRepository;

    private UserLabService(UserLabRepository userLabRepository, RoleRepository roleRepository) {
        this.userLabRepository = userLabRepository;
        this.roleRepository = roleRepository;
    }

    public UserLabDto registerUser(NewUserLabDto newUser) {
        System.out.println(newUser.getEmail());
        UserLab userLab = new UserLab();
        userLab.setEmail(newUser.getEmail());
        userLab.setPassword(newUser.getPassword());
        userLab.setUsername(newUser.getUsername());

        Role role = this.roleRepository.findRoleByName(newUser.getRole());
        userLab.getRoles().add(role);

        userLabRepository.save(userLab);
        UserLabDto returnUser = new UserLabDto(userLab.getUsername(), userLab.getEmail(), userLab.getPassword());
        returnUser.getRoles().add(role);
        return returnUser;
    }
}

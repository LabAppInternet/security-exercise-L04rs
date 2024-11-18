package cat.tecnocampus.securityjwt.app.dto;

import cat.tecnocampus.securityjwt.domain.ERole;
import cat.tecnocampus.securityjwt.domain.Role;

import java.util.HashSet;
import java.util.Set;

public class UserLabDto {

    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();


    public UserLabDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

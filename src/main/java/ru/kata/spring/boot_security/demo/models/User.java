package ru.kata.spring.boot_security.demo.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @NotEmpty(message = "Can't empty")
    @Size(min = 2, max = 100, message = "From 2 to 100 characters")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "Can't empty")
    @Size(min = 2, max = 100, message = "From 2 to 100 characters")
    @Column(name = "password")
    private String password;

    @Column(name = "enabled", columnDefinition = "TINYINT")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Role> authority;

    public User() {

    }

    public User(Long id, String username) {
        this.username = username;
    }

    public Collection<Role> getAuthority() {
        return authority;
    }

    public void setAuthority(Collection<Role> authority) {
        this.authority = authority;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthority();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", authority=" + authority +
                '}';
    }
}

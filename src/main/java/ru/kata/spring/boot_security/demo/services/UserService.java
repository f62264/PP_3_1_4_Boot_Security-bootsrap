package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<User> findAll();

    public User saveUser(User user);

    public void deleteById(Long id);

    public User findById(Long id);

    public User findByUsername(String username);

}

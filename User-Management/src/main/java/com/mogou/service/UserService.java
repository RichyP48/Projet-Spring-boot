package com.mogou.service;

import com.mogou.model.User;
import com.mogou.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repo, PasswordEncoder encoder){
        this.repo = repo; this.encoder = encoder;
    }

    public User create(String name, String email, String rawPassword){
        if(repo.existsByEmail(email)) throw new IllegalArgumentException("Email already used");
        User u = User.builder()
                .name(name).email(email)
                .password(encoder.encode(rawPassword))
                .role(User.Role.USER).build();
        return repo.save(u);
    }

    public List<User> findAll(){ return repo.findAll(); }
    public User findById(Long id){ return repo.findById(id).orElseThrow(); }
    public void delete(Long id){ repo.deleteById(id); }
    public User update(Long id, User updated){
        return repo.findById(id).map(u -> {
            u.setName(updated.getName());
            u.setEmail(updated.getEmail());
            return repo.save(u);
        }).orElseThrow();
    }
}
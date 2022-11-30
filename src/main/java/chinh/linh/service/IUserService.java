package chinh.linh.service;

import chinh.linh.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUserName(String name);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User save(User user);
}

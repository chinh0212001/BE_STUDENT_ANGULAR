package chinh.linh.service.impl;

import chinh.linh.model.User;
import chinh.linh.reponsitory.IUserRepository;
import chinh.linh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceIMPL implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public Optional<User> findByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}

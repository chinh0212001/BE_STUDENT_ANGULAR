package chinh.linh.service;

import chinh.linh.model.Role;
import chinh.linh.model.RoleName;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IRole {
    Optional<Role> findByName(RoleName name);
}

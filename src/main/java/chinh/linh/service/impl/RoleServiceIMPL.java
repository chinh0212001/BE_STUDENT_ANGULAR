package chinh.linh.service.impl;

import chinh.linh.model.Role;
import chinh.linh.model.RoleName;
import chinh.linh.reponsitory.IRoleRepository;
import chinh.linh.service.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceIMPL implements IRole {
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}

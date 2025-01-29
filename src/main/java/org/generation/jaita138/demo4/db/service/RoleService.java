package org.generation.jaita138.demo4.db.service;

import java.util.List;

import org.generation.jaita138.demo4.db.entity.Role;
import org.generation.jaita138.demo4.db.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public void save(Role role) {
        roleRepo.save(role);
    }

    public void delete(Role role) {
        roleRepo.delete(role);
    }

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    public Role findById(Long id) {
        return roleRepo.findById(id).orElse(null);
    }
}

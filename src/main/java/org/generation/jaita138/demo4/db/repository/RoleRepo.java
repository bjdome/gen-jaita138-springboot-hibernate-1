package org.generation.jaita138.demo4.db.repository;

import org.generation.jaita138.demo4.db.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

}

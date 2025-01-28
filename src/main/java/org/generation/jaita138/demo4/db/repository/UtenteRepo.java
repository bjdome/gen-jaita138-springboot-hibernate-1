package org.generation.jaita138.demo4.db.repository;

import org.generation.jaita138.demo4.db.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {

}

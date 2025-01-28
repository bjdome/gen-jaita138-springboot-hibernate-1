package org.generation.jaita138.demo4.db.repository;

import java.util.List;

import org.generation.jaita138.demo4.db.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
    
    List<Utente> findByNomeStartsWith(String iniziale);

    List<Utente> findByCreditoGreaterThan(int credito);

    List<Utente> findByNomeNullOrCognomeNull();

    List<Utente> findByCreditoBetween(int min, int max);
}

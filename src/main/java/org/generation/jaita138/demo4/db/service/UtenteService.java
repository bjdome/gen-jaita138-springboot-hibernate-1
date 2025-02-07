package org.generation.jaita138.demo4.db.service;

import java.util.List;

import org.generation.jaita138.demo4.db.entity.Utente;
import org.generation.jaita138.demo4.db.repository.UtenteRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    public void save(Utente utente) {
        utenteRepo.save(utente);
    }

    public void delete(Utente utente) {
        utenteRepo.delete(utente);
    }

    public List<Utente> findAll() {
        return utenteRepo.findAll();
    }

    @Transactional
    public Utente findById(long id){
        Utente utente = utenteRepo.findById(id).orElse(null);
        if(utente != null)
            Hibernate.initialize(utente.getSubReddits());

        return utente;
    }

    public List<Utente> findByNomeStartsWith(String iniziale){
        return utenteRepo.findByNomeStartsWith(iniziale);
    }

    public List<Utente> findByCreditoGreaterThan(int credito){
return utenteRepo.findByCreditoGreaterThan(credito);
    }

    public List<Utente> findByNomeNullOrCognomeNull(){
return utenteRepo.findByNomeNullOrCognomeNull();
    }

    public List<Utente> findByCreditoBetween(int min, int max){
        return utenteRepo.findByCreditoBetween(min, max);
    }
}

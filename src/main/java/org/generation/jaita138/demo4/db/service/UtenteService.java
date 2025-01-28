package org.generation.jaita138.demo4.db.service;

import java.util.List;

import org.generation.jaita138.demo4.db.entity.Utente;
import org.generation.jaita138.demo4.db.repository.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Utente findById(Long id) {
        return utenteRepo.findById(id).orElse(null);
    }
}

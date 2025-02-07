package org.generation.jaita138.demo4.db.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class SubReddit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=64)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(mappedBy = "subReddits")
    private List<Utente> utenti;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Utente> getUtenti() {
        return utenti;
    }
    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }
    @Override
    public String toString() {
        return "SubReddit [\n"
            + "  id: " + id + ",\n"
            + "  name: " + name + ",\n"
            + "  description: " + description + "\n"
            + "]";
    }
    

}

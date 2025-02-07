package org.generation.jaita138.demo4;

import java.util.List;

import org.generation.jaita138.demo4.cli.CliManager;
import org.generation.jaita138.demo4.db.entity.Role;
import org.generation.jaita138.demo4.db.entity.Utente;
import org.generation.jaita138.demo4.db.service.RoleService;
import org.generation.jaita138.demo4.db.service.SubRedditService;
import org.generation.jaita138.demo4.db.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo4Application implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private SubRedditService subRedditService;

    public static void main(String[] args) {
        SpringApplication.run(Demo4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //test();
        //new CliManager(utenteService);
        //testQuery();
        //testRole();
        //new CliManager(utenteService, roleService);
        new CliManager (utenteService, roleService, subRedditService);
    }

    public void test() {

        System.out.println("--------------------------------");
        Utente u1 = new Utente();
        u1.setNome("Mario");
        u1.setCognome("Rossi");
        u1.setUsername("mRossi");
        u1.setPassword("123456");
        u1.setCredito(1090);
        utenteService.save(u1);
        List<Utente> utenti = utenteService.findAll();
        utenteService.findById(1L);
        utenteService.delete(utenti.get(0));
        System.out.println(u1);
        System.out.println(utenti);
        System.out.println("--------------------------------");
        System.out.println("The end");
    }

    public void testQuery() {
        System.out.println("--------------------------------");
        List<Utente> utenti = utenteService.findByNomeStartsWith("a");
        System.out.println(utenti);

        System.out.println("--------------------------------");

        utenti = utenteService.findByCreditoGreaterThan(10 * 100);
        System.out.println(utenti);

        System.out.println("--------------------------------");

        utenti = utenteService.findByNomeNullOrCognomeNull();
        System.out.println(utenti);

        System.out.println("--------------------------------");

        utenti = utenteService.findByCreditoBetween(0, 10 * 100);
        System.out.println(utenti);

        System.out.println("--------------------------------");
        System.out.println("The end");

    }

    public void testRole(){
        Role r1 = new Role();
        r1.setNome("Admin");
        r1.setDescrizione("Amministratore");
        roleService.save(r1);
    }
}

package org.generation.jaita138.demo4.cli;

import java.util.List;
import java.util.Scanner;

import org.generation.jaita138.demo4.db.entity.Role;
import org.generation.jaita138.demo4.db.entity.Utente;
import org.generation.jaita138.demo4.db.service.RoleService;
import org.generation.jaita138.demo4.db.service.UtenteService;

public class CliManager {

    private Scanner sc;
    private UtenteService utenteService;
    private RoleService roleService;

    public CliManager(UtenteService utenteService) {

        sc = new Scanner(System.in);
        this.utenteService = utenteService;

        printOptions();
    }

    public CliManager(UtenteService utenteService, RoleService roleService) {
        sc = new Scanner(System.in);
        this.utenteService = utenteService;
        this.roleService = roleService;

        printOptions2();
    }

    private void printOptions() {

        System.out.println("Operazioni:");
        System.out.println("1. Leggi tutta la tabella");
        System.out.println("2. Inserisci nuovo record");
        System.out.println("3. Modifica record");
        System.out.println("4. Elimina record");
        System.out.println("5. Esci");
        System.out.println("");

        String strValue = sc.nextLine();
        int value = Integer.parseInt(strValue);

        switch (value) {

            case 1:
                readAll();
                break;
            case 2:
                insert();
                break;
            case 3:
                edit();
                break;
            case 4:
                delete();
                break;
            case 5:
                return;

            default:
                System.out.println("Operazione non valida");
                break;
        }

        printOptions();
    }

    private void printOptions2() {

        System.out.println("Operazioni:");
        System.out.println("1. Leggi la tabella Utenti");
        System.out.println("2. Leggi la tabella Ruoli");
        System.out.println("3. Inserisci nuovo Utente");
        System.out.println("4. Inserisci nuovo Ruolo");
        System.out.println("5. Modifica un Utente");
        System.out.println("6. Modifica un Ruolo");
        System.out.println("7. Elimina un Utente");
        System.out.println("8. Elimina un Ruolo");
        System.out.println("9. Esci");
        System.out.println("");

        String strValue = sc.nextLine();
        int value = Integer.parseInt(strValue);

        switch (value) {

            case 1:
                readAll();
                break;
            case 2:
                readRole();
                break;
            case 3:
                insert();
                break;
            case 4:
                insertRole();
                break;
            case 5:
                edit();
                break;
            case 6:
                editRole();
                break;
            case 7:
                delete();
                break;
            case 8:
                deleteRole();
                break;
            case 9:
                return;

            default:
                System.out.println("Operazione non valida");
                break;
        }

        printOptions2();
    }

    private void readAll() {

        List<Utente> utenti = utenteService.findAll();
        System.out.println("Utenti:");
        System.out.println(utenti);
        System.out.println("-------------------------------------");
    }

    private void readRole() {

        List<Role> ruoli = roleService.findAll();
        System.out.println("Ruoli:");
        System.out.println(ruoli);
        System.out.println("-------------------------------------");
    }

    private void insert() {

        Utente u = new Utente();

        System.out.println("nome:");
        String nome = sc.nextLine();
        u.setNome(nome);

        System.out.println("cognome:");
        String cognome = sc.nextLine();
        u.setCognome(cognome);

        System.out.println("username:");
        String username = sc.nextLine();
        u.setUsername(username);

        System.out.println("password:");
        String password = sc.nextLine();
        u.setPassword(password);

        System.out.println("credito:");
        String strCredito = sc.nextLine();
        int credito = Integer.parseInt(strCredito);
        u.setCredito(credito);

        System.out.println("ruoli:");
        List<Role> ruoli = roleService.findAll();
        System.out.println(ruoli);
        System.out.println("id ruolo:");
        String strRole = sc.nextLine();
        Long idRole = Long.parseLong(strRole);
        Role role = roleService.findById(idRole);
        u.setRole(role);

        utenteService.save(u);
    }

    private void insertRole() {

        Role r = new Role();

        System.out.println("nome:");
        String nome = sc.nextLine();
        r.setNome(nome);

        System.out.println("descrizione:");
        String descrizione = sc.nextLine();
        r.setDescrizione(descrizione);

        roleService.save(r);
    }

    private void edit() {

        System.out.println("edit id:");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        Utente u = utenteService.findById(id);

        if (u == null) {

            System.out.println("Utente non trovato");
            return;
        }

        System.out.println("nome: (" + u.getNome() + ")");
        String nome = sc.nextLine();
        u.setNome(nome);

        System.out.println("cognome: (" + u.getCognome() + ")");
        String cognome = sc.nextLine();
        u.setCognome(cognome);

        System.out.println("username: (" + u.getUsername() + ")");
        String username = sc.nextLine();
        u.setUsername(username);

        System.out.println("password: (" + u.getPassword() + ")");
        String password = sc.nextLine();
        u.setPassword(password);

        System.out.println("credito: (" + u.getCredito() + ")");
        String strCredito = sc.nextLine();
        int credito = Integer.parseInt(strCredito);
        u.setCredito(credito);

        System.out.println("ruoli: (" + u.getRole() + ")");
        List<Role> ruoli = roleService.findAll();
        System.out.println(ruoli);
        System.out.println("id ruolo:");
        String strRole = sc.nextLine();
        Long idRole = Long.parseLong(strRole);
        Role role = roleService.findById(idRole);
        u.setRole(role);

        utenteService.save(u);
    }

    private void editRole() {

        System.out.println("edit id:");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        Role r = roleService.findById(id);

        if (r == null) {

            System.out.println("Ruolo non trovato");
            return;
        }

        System.out.println("nome: (" + r.getNome() + ")");
        String nome = sc.nextLine();
        r.setNome(nome);

        System.out.println("descrizione: (" + r.getDescrizione() + ")");
        String descrizione = sc.nextLine();
        r.setDescrizione(descrizione);

        roleService.save(r);
    }

    private void delete() {

        System.out.println("delete id:");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        Utente u = utenteService.findById(id);

        if (u != null) {
            utenteService.delete(u);
            System.out.println("Utente " + strId + " eliminato");
        } else {
            System.out.println("Utente non trovato");
        }
    }

    private void deleteRole() {

        System.out.println("delete id:");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        Role r = roleService.findById(id);

        if (r != null) {
            roleService.delete(r);
            System.out.println("Ruolo " + strId + " eliminato");
        } else {
            System.out.println("Ruolo non trovato");
        }
    }
}

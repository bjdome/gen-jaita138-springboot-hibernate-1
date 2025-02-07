package org.generation.jaita138.demo4.cli;

import java.util.List;
import java.util.Scanner;

import org.generation.jaita138.demo4.db.entity.Role;
import org.generation.jaita138.demo4.db.entity.SubReddit;
import org.generation.jaita138.demo4.db.entity.Utente;
import org.generation.jaita138.demo4.db.service.RoleService;
import org.generation.jaita138.demo4.db.service.SubRedditService;
import org.generation.jaita138.demo4.db.service.UtenteService;

public class CliManager {

    private Scanner sc;
    private UtenteService utenteService;
    private RoleService roleService;
    private SubRedditService subRedditService;

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

    public CliManager(UtenteService utenteService, RoleService roleService, SubRedditService subRedditService) {
        sc = new Scanner(System.in);
        this.utenteService = utenteService;
        this.roleService = roleService;
        this.subRedditService = subRedditService;

        printOptions3();
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
        System.out.println("8. Esci");
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
                return;

            default:
                System.out.println("Operazione non valida");
                break;
        }

        printOptions2();
    }

    private void printOptions3() {
        System.out.println("Operazioni:");
        System.out.println("1. Leggi la tabella Utenti");
        System.out.println("2. Leggi la tabella Ruoli");
        System.out.println("3. Leggi la tabella SubReddit");
        System.out.println("4. Inserisci nuovo Utente");
        System.out.println("5. Inserisci nuovo Ruolo");
        System.out.println("6. Inserisci nuovo SubReddit");
        System.out.println("7. Modifica un Utente");
        System.out.println("8. Modifica un Ruolo");
        System.out.println("9. Modifica un SubReddit");
        System.out.println("10. Elimina un Utente");
        System.out.println("11. Esci");
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
                readSubReddit();
                break;
            case 4:
                insert();
                break;
            case 5:
                insertRole();
                break;
            case 6:
                insertSubReddit();
                break;
            case 7:
                edit();
                break;
            case 8:
                editRole();
                break;
            case 9:
                editSubReddit();
                break;
            case 10:
                delete();
                break;
            case 11:
                return;

            default:
                System.out.println("Operazione non valida");
                break;
        }

        printOptions3();
    }
    
    private void readAll() {

        List<Utente> utenti = utenteService.findAll();
        System.out.println("Utenti:");
        utenti.stream()
            .map(u -> u.getId() + " - " 
            + u.getNome() + " - " 
            + u.getCognome() + " - " 
            + u.getUsername() + " - " 
            + u.getPassword() + " - " 
            + u.getCredito()/100 + "," + u.getCredito()%100 + " - " 
            + (u.getRole() == null ? "Nessun ruolo" : u.getRole().getNome()))
            .forEach(System.out::println);
        System.out.println("-------------------------------------");
    }

    private void readRole() {

        List<Role> ruoli = roleService.findAll();
        System.out.println("Ruoli:");
        ruoli.stream()
            .map(r -> r.getId() + " - " + r.getNome() + "\n" + r.getDescrizione())
            .forEach(System.out::println);
        System.out.println("-------------------------------------");
    }

    private void readSubReddit(){
        List<SubReddit> subReddits = subRedditService.findAll();
        System.out.println("SubReddit:");
        subReddits.stream()
            .map(s -> s.getId() + " - " + s.getName() + "\n" + s.getDescription())
            .forEach(System.out::println);
        System.out.println("-------------------------------------");
    }

    private void insert() {

        Utente u = new Utente();

        save(u);
    }

    private void insertRole() {

        Role r = new Role();

        saveRole(r);
    }

    private void insertSubReddit() {
        SubReddit s = new SubReddit();
        saveSubReddit(s);
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
        save(u);
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

        saveRole(r);
    }

    private void editSubReddit() {
        System.out.println("edit id:");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        SubReddit s = subRedditService.findById(id);

        if (s == null) {

            System.out.println("SubReddit non trovato");
            return;
        }

        saveSubReddit(s);
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

    private void deleteSubReddit() {
        System.out.println("delete id:");
        String strId = sc.nextLine();
        Long id = Long.parseLong(strId);
        SubReddit s = subRedditService.findById(id);

        if (s != null) {
            subRedditService.delete(s);
            System.out.println("SubReddit " + strId + " eliminato");
        } else {
            System.out.println("SubReddit non trovato");
        }
    }

    private void save(Utente u) {
        boolean isNew = u.getId() == null;

        System.out.println("Nome: " + (isNew ? "" : "(" + u.getNome() + ")"));
        String nome = sc.nextLine();
        u.setNome(nome);

        System.out.println("Cognome: " + (isNew ? "" : "(" + u.getCognome() + ")"));
        String cognome = sc.nextLine();
        u.setCognome(cognome);

        System.out.println("Username: " + (isNew ? "" : "(" + u.getUsername() + ")"));
        String username = sc.nextLine();
        u.setUsername(username);

        System.out.println("Password: " + (isNew ? "" : "(" + u.getPassword() + ")"));
        String password = sc.nextLine();
        u.setPassword(password);

        System.out.println("Credito: " + (isNew ? "" : "(" + u.getCredito()/100+","+u.getCredito()%100 + ")"));
        String strCredito = sc.nextLine();
        int credito = Integer.parseInt(strCredito);
        u.setCredito(credito);

        System.out.println("Ruoli: " + (isNew ? "" : "(" + u.getRole() + ")"));
        List<Role> ruoli = roleService.findAll();
        ruoli.stream()
            .map(r -> r.getId() + " - " + r.getNome())
            .forEach(System.out::println);
        String roleIdStr = (isNew ? "" : "(" + u.getRole().getId() + ")");

        System.out.println("Id ruolo:" + (isNew ? "" : roleIdStr ));
        String strRole = sc.nextLine();
        Long idRole = Long.parseLong(strRole);
        Role role = roleService.findById(idRole);
        u.setRole(role);

        String hasSubReddit = "y";
        List<SubReddit> subReddits = subRedditService.findAll();
        while (hasSubReddit.equals("y")) {

            System.out.println("Ha un sub reddit? (y/n)");
            hasSubReddit = sc.nextLine();

            if (!hasSubReddit.equals("y")) {
                utenteService.save(u);
                return;
            }

            List<SubReddit> subDisp = availableSubReddits(u);
            if (subDisp.isEmpty()) {
                System.out.println("Non ci sono SubReddit disponibili!");
                break;
            }

            System.out.println("SubReddit disponibili: ");
            subDisp.forEach(System.out::println);

            System.out.println("SubReddit id: ");
            String subRedditIdStr = sc.nextLine();
            Long subRedditId = Long.parseLong(subRedditIdStr);

            SubReddit subReddit = subRedditService.findById(subRedditId);
            if (subReddit == null) {
                System.out.println("SubReddit non trovato");
                continue;
            }

            u.getSubReddits().add(subReddit);
        }
        utenteService.save(u);
    }

    private List<SubReddit> availableSubReddits(Utente utente){
        List<Long> subRedditId = utente.getSubReddits().stream().map(SubReddit::getId).toList();
        return subRedditService.findAll().stream().filter(subR -> !subRedditId.contains(subR.getId())).toList();
    }

    private void saveRole(Role r) {
        boolean isNew = r.getId() == null;

        System.out.println("Nome: " + (isNew ? "" : "(" + r.getNome() + ")"));
        String nome = sc.nextLine();
        r.setNome(nome);

        System.out.println("Descrizione: " + (isNew ? "" : "(" + r.getDescrizione() + ")"));
        String descrizione = sc.nextLine();
        r.setDescrizione(descrizione);

        roleService.save(r);

    }

    private void saveSubReddit(SubReddit s) {
        boolean isNew = s.getId() == null;

        System.out.println("Nome: " + (isNew ? "" : "(" + s.getName() + ")"));
        String name = sc.nextLine();
        s.setName(name);

        System.out.println("Descrizione: " + (isNew ? "" : "(" + s.getDescription() + ")"));
        String description = sc.nextLine();
        s.setDescription(description);

        subRedditService.save(s);
    }
}

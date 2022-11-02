package entity;

import repository.implementation.activiteRepository;
import repository.implementation.adminRepository;

public class App {
    public static void main(String[] args) {
        Activite activite = new Activite();
        activite.setTitre("testing");

        activiteRepository rep = new activiteRepository();
        rep.add(activite);
        System.out.println("added activite"+ activite.toString());

        Admin admin = new Admin();
        admin.setNom("khadija");

        adminRepository repA = new adminRepository();
        repA.add(admin);
        System.out.println("added Admin"+ admin.toString());
    }
}

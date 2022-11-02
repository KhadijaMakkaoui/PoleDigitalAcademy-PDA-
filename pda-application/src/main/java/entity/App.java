package entity;

import repository.implementation.activiteRepoImp;
import repository.implementation.adminRepoImp;

public class App {
    public static void main(String[] args) {
        Activite activite = new Activite();
        activite.setTitre("testing");

        activiteRepoImp rep = new activiteRepoImp();
        rep.add(activite);
        System.out.println("added activite"+ activite.toString());

        Admin admin = new Admin();
        admin.setNom("khadija");




        adminRepoImp repA = new adminRepoImp();
        repA.add(admin);
        repA.findByLogin();
        System.out.println("added Admin"+ admin.toString());
    }
}

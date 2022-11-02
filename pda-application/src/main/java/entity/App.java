package entity;

import repository.implementation.activiteImp;
import repository.implementation.adminImp;

public class App {
    public static void main(String[] args) {
        Activite activite = new Activite();
        activite.setTitre("testing");

        activiteImp rep = new activiteImp();
        rep.add(activite);
        System.out.println("added activite"+ activite.toString());

        Admin admin = new Admin();
        admin.setNom("khadija");

        adminImp repA = new adminImp();
        repA.add(admin);
        System.out.println("added Admin"+ admin.toString());
    }
}

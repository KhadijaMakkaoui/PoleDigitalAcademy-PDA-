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
        admin.setLogin("khadija");
        admin.setPassword("123");



        adminRepoImp repA = new adminRepoImp();
        repA.add(admin);

        System.out.println(repA.auth("khadija","123"));
    }
}

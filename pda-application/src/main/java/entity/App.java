package entity;

import repository.implementation.activiteRepoImp;
import repository.implementation.adminRepoImp;
import service.implementation.adminServiceImp;

public class App {
    public static void main(String[] args) {
        //Activite activite = new Activite();
        //activite.setTitre("testing");

        //activiteRepoImp rep = new activiteRepoImp();
        //rep.add(activite);
        //System.out.println("added activite"+ activite.toString());

        Admin admin = new Admin();
        admin.setLogin("khadija");
        admin.setPassword("123");
        adminServiceImp asi = new adminServiceImp();
        asi.add(admin);



        boolean asicon = asi.auth("khadija", "123");
        System.out.println(asicon);
    }
}

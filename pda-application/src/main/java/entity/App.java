package entity;

<<<<<<< HEAD
import repository.implementation.activiteImp;
=======
import repository.implementation.activiteRepository;
import repository.implementation.adminRepository;
>>>>>>> fbe281d3842df511c97cb06e662d5a9ab60318a0

public class App {
    public static void main(String[] args) {
        Activite activite = new Activite();
        activite.setTitre("testing");

        activiteImp rep = new activiteImp();
        rep.add(activite);
        System.out.println("added activite"+ activite.toString());

        Admin admin = new Admin();
        admin.setNom("khadija");

        adminRepository repA = new adminRepository();
        repA.add(admin);
        System.out.println("added Admin"+ admin.toString());
    }
}

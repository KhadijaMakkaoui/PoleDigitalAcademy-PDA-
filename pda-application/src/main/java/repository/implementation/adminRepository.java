package repository.implementation;

import entity.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.repositoryInterface;

public class adminRepository implements repositoryInterface<Admin> {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public adminRepository() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.entityManager = this.emf.createEntityManager();
    }

    public Admin add(Admin admin) {
        entityManager.getTransaction().begin();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
        return admin;
    }

    public Admin find(int id) {
        return entityManager.find(Admin.class, id);
    }

    public Admin update(Admin admin) {
        Admin adminToUpdate = find(admin.getId_user());

        entityManager.getTransaction().begin();
        adminToUpdate.setDomaine(admin.getDomaine());
        adminToUpdate.setEmail(admin.getEmail());
        adminToUpdate.setNom(admin.getNom());
        adminToUpdate.setPrenom(admin.getPrenom());
        adminToUpdate.setPhone(admin.getPhone());
        adminToUpdate.setRole(admin.getRole());
        adminToUpdate.setEtat(admin.getEtat());
        adminToUpdate.setLogin(admin.getLogin());
        adminToUpdate.setPassword(admin.getPassword());
        entityManager.getTransaction().commit();

        return adminToUpdate;
    }

    public void delete(Admin admin) {
        entityManager.getTransaction().begin();
        entityManager.remove(admin);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}

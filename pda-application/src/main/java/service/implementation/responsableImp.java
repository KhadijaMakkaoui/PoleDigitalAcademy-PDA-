package service.implementation;

import entity.Responsable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.IRepository;

public class responsableImp implements IRepository<Responsable> {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public responsableImp() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.entityManager = this.emf.createEntityManager();
    }

    public Responsable add(Responsable responsable) {
        entityManager.getTransaction().begin();
        entityManager.persist(responsable);
        entityManager.getTransaction().commit();
        return responsable;
    }

    public Responsable find(int id) {
        return entityManager.find(Responsable.class, id);
    }

    public Responsable update(Responsable responsable) {
        Responsable responsableToUpdate = find(responsable.getId_user());

        entityManager.getTransaction().begin();
        responsableToUpdate.setDomaine(responsable.getDomaine());
        responsableToUpdate.setEmail(responsable.getEmail());
        responsableToUpdate.setNom(responsable.getNom());
        responsableToUpdate.setPrenom(responsable.getPrenom());
        responsableToUpdate.setPhone(responsable.getPhone());
        responsableToUpdate.setRole(responsable.getRole());
        responsableToUpdate.setEtat(responsable.getEtat());
        responsableToUpdate.setType(responsable.getType());
        responsableToUpdate.setEtat(responsable.getEtat());

        entityManager.getTransaction().commit();

        return responsableToUpdate;
    }

    public void delete(Responsable responsable) {
        entityManager.getTransaction().begin();
        entityManager.remove(responsable);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}

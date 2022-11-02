package repository.implementation;

import entity.Activite;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.IRepository;

public class activiteImp implements IRepository<Activite> {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public activiteImp() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.entityManager = this.emf.createEntityManager();
    }
    public Activite add(Activite activite) {
        entityManager.getTransaction().begin();
        entityManager.persist(activite);
        entityManager.getTransaction().commit();
        return activite;
    }

    public Activite find(int id) {
        return entityManager.find(Activite.class, id);
    }

    public Activite update(Activite activite) {
        Activite activiteToUpdate = find(activite.getId_activite());

        entityManager.getTransaction().begin();
        activiteToUpdate.setTitre(activite.getTitre());
        activiteToUpdate.setDescriptif(activite.getDescriptif());
        entityManager.getTransaction().commit();

        return activiteToUpdate;
    }

    public void delete(Activite activite) {
        entityManager.getTransaction().begin();
        entityManager.remove(activite);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }


}

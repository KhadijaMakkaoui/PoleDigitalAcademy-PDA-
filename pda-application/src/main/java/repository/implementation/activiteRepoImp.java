package repository.implementation;

import java.util.List;

import entity.Activite;
import entity.Exercice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import repository.IRepository;

public class activiteRepoImp implements IRepository<Activite> {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public activiteRepoImp() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.entityManager = this.emf.createEntityManager();
    }
    public Activite add(Activite activite) {
        entityManager.getTransaction().begin();
        entityManager.persist(activite);
        entityManager.getTransaction().commit();
        return activite;
    }
    
    @SuppressWarnings("unchecked")
	public List<Activite> getAll() {
        Query query = entityManager.createNativeQuery("select * from activite", Activite.class);
        return query.getResultList();
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

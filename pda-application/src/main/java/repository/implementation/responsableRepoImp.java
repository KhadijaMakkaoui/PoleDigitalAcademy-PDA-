package repository.implementation;

import java.util.List;

import entity.Participant;
import entity.Responsable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import repository.IRepository;

public class responsableRepoImp implements IRepository<Responsable> {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public responsableRepoImp() {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.entityManager = this.emf.createEntityManager();
    }

    public Responsable add(Responsable responsable) {
        entityManager.getTransaction().begin();
        entityManager.persist(responsable);
        entityManager.getTransaction().commit();
        return responsable;
    }
    
    @SuppressWarnings("unchecked")
	public List<Responsable> getAll() {
        Query query = entityManager.createNativeQuery("select * from responsable", Responsable.class);
        return query.getResultList();
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

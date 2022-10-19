package by.spring.animalclinic.repository.jpa;

import by.spring.animalclinic.model.Owner;
import by.spring.animalclinic.repository.OwnerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class JpaOwnerRepositoryImpl implements OwnerRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Owner owner) {
        if (owner.isNew()) {
            em.persist(owner);
        } else {
            em.merge(owner);
        }
    }

    @Override
    public Owner findById(Long id) {
        Query query = em.createQuery("SELECT o FROM Owner o left join FETCH o.pets WHERE o.id = :id ");
        query.setParameter("id", id);
        return (Owner) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Owner> findByLastName(String lastName) {
        Query query = em.createQuery("SELECT DISTINCT o FROM Owner o left join FETCH o.pets WHERE o.lastName = :lastName");
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
}


package by.spring.animalclinic.repository.jpa;

import by.spring.animalclinic.model.Pet;
import by.spring.animalclinic.model.PetType;
import by.spring.animalclinic.repository.PetRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class JpaPetRepositoryImpl implements PetRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Pet pet) {
        if (pet.isNew()) {
            em.persist(pet);
        } else {
            em.merge(pet);
        }
    }

    @Override
    public Pet findById(Long id) {
        return em.find(Pet.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<PetType> findPetTypes() {
        return em.createQuery("SELECT pt FROM PetType pt ORDER BY pt.name ").getResultList();
    }
}

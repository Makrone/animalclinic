package by.spring.animalclinic.repository;

import by.spring.animalclinic.model.Pet;
import by.spring.animalclinic.model.PetType;

import java.util.Collection;

public interface PetRepository {

    void save(Pet pet);

    Pet findById(Long id);

    Collection<PetType> findPetTypes ();

}

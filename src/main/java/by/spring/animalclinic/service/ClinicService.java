package by.spring.animalclinic.service;

import by.spring.animalclinic.model.Owner;
import by.spring.animalclinic.model.Pet;
import by.spring.animalclinic.model.PetType;

import java.util.Collection;

public interface ClinicService {

    Collection<PetType> findPetTypes();

    Owner findOwnerById(Long id);

    Pet findPetById(Long id);

    void savePet(Pet pet);

    void saveOwner(Owner owner);

    Collection<Owner> findOwnerByLastName(String lastName);
}

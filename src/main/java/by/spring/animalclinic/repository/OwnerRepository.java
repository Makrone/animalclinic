package by.spring.animalclinic.repository;

import by.spring.animalclinic.model.Owner;

import java.util.Collection;

public interface OwnerRepository {

    void save(Owner owner);

    Owner findById (Long id);

    Collection<Owner> findByLastName (String lastName);
}

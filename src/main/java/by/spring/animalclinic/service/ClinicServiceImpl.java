package by.spring.animalclinic.service;

import by.spring.animalclinic.model.Owner;
import by.spring.animalclinic.model.Pet;
import by.spring.animalclinic.model.PetType;
import by.spring.animalclinic.repository.OwnerRepository;
import by.spring.animalclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClinicServiceImpl implements ClinicService {
    private OwnerRepository ownerRepository;
    private PetRepository petRepository;

    @Autowired
    public ClinicServiceImpl(OwnerRepository ownerRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
    }

    @Override
    public Collection<PetType> findPetTypes() {
        return petRepository.findPetTypes();
    }

    @Override
    public Owner findOwnerById(Long id) {

        return ownerRepository.findById(id);
    }

    @Override
    public Pet findPetById(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public Collection<Owner> findOwnerByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}

package sheridan.sin12743.assignment2.service;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sheridan.sin12743.assignment2.model.Pet;
import sheridan.sin12743.assignment2.repository.PetRepository;

import java.util.List;

@Service
public class PetService {
    //petservices
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {

        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {

        return petRepository.findAll();
    }

    public void savePet(@Valid Pet pet) {

        petRepository.save(pet);
    }

    public Pet getPetById(long id) {
        return petRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid pet Id:" + id));
    }

    public void deletePet(long id) {

        petRepository.deleteById(id);
    }
}


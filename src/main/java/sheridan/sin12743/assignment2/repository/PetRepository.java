package sheridan.sin12743.assignment2.repository;

import sheridan.sin12743.assignment2.model.Pet ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//interface
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}

package zoo.simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zoo.simulator.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findAnimalByName(String name);
}
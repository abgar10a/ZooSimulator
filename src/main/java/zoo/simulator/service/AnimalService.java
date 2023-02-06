package zoo.simulator.service;

import org.springframework.transaction.annotation.Transactional;
import zoo.simulator.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoo.simulator.repository.AnimalRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class AnimalService {

    private static final Logger LOGGER = Logger.getLogger(AnimalService.class.getName());

    @Autowired
    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public Animal findAnimalByName(String name) {
        return animalRepository.findAnimalByName(name);
    }

    public void removeAnimal(Animal animal) {
        animalRepository.delete(animal);
    }

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    public void feedAnimal(String name, double foodWeight) {
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            animal.setWeight(animal.getWeight() + foodWeight);
            animalRepository.save(animal);
        }
    }

}
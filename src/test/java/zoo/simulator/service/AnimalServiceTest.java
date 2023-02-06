package zoo.simulator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import zoo.simulator.model.Animal;
import zoo.simulator.repository.AnimalRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    @Mock
    private AnimalRepository animalRepository;
    private AnimalService animalService;

    @BeforeEach
    public void setUp() {
        this.animalService = new AnimalService(animalRepository);
    }

    @Test
    void addAnimal() {
        Animal animal = new Animal("Lion", 200, 5);
        animalService.addAnimal(animal);
        assertEquals(animal, animalRepository.findAnimalByName(animal.getName()));
    }

    @Test
    void findAnimalByName() {
        Animal lion = animalService.findAnimalByName("Lion");
        assertEquals("Lion", lion.getName());
    }

    @Test
    void removeAnimal() {
        Animal animal = new Animal("Lion", 200, 5);
        animalService.removeAnimal(animal);
        assertNull(animalService.findAnimalByName("Lion"));
    }

    @Test
    void feedAnimal() {
        Animal animal = new Animal("Lion", 200, 5);
        double foodWeight = 1.2;
        animalService.feedAnimal("Lion", foodWeight);
        assertEquals(animal.getWeight()+foodWeight, animalService.findAnimalByName("Lion").getWeight());
    }
}


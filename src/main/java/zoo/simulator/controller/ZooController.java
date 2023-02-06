package zoo.simulator.controller;

import zoo.simulator.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zoo.simulator.service.AnimalService;

import java.util.List;

@RestController
public class ZooController {

    @Autowired
    private AnimalService animalService;

    @PostMapping("/api/animals")
    public void addAnimal(@RequestBody Animal animal) {
        animalService.addAnimal(animal);
    }

    @DeleteMapping("/api/animals/{name}")
    public void removeAnimal(@PathVariable String name) {
        Animal animal = animalService.findAnimalByName(name);
        if (animal != null) {
            animalService.removeAnimal(animal);
        }
    }

    @GetMapping("/api/animals")
    public List<Animal> getAnimals() {
        return animalService.getAnimals();
    }

    @PostMapping("/api/animals/{name}/feed")
    public void feedAnimal(@PathVariable String name, @RequestBody double foodWeight) {
        animalService.feedAnimal(name, foodWeight);
    }
}
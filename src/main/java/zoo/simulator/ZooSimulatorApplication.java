package zoo.simulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zoo.simulator.model.Animal;
import zoo.simulator.repository.AnimalRepository;

import java.util.List;

@SpringBootApplication
public class ZooSimulatorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ZooSimulatorApplication.class, args);
	}

	@Autowired
	private AnimalRepository animalRepository;

	@Override
	public void run(String... args) throws Exception {
		List<Animal> animals = animalRepository.findAll();
		animalRepository.save(new Animal("Lion", 200, 5));
		animalRepository.save(new Animal("Pig", 35, 1/2));
		animalRepository.save(new Animal("Dog", 6, 1));
		animalRepository.save(new Animal("Cat", 4, 2));
		animalRepository.flush();
		System.out.println(52);
	}


}

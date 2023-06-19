package sheridan.sin12743.assignment2;


import sheridan.sin12743.assignment2.model.Pet ;
import sheridan.sin12743.assignment2.service.PetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
//application
@SpringBootApplication
public class Assignment2Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment2Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PetService petService) {
        return (args) -> {
            List<Pet> pets = Arrays.asList(
                    new Pet("Fluffy", "Cat", "Female", true),
                    new Pet("Rover", "Dog", "Male", true),
                    new Pet("Bunny", "Rabbit", "Female", false),
                    new Pet("Max", "Dog", "Male", false),
                    new Pet("Snowy", "Cat", "Female", true)
            );

            pets.forEach(petService::savePet);
        };
    }
}
package ua.com.alevel;

import ua.com.alevel.entity.Animal;
import ua.com.alevel.entity.Owner;
import ua.com.alevel.entity.type.AnimalType;
import ua.com.alevel.service.AnimalService;
import ua.com.alevel.service.OwnerService;

import java.util.List;

public class TestController {

    private AnimalService animalService = new AnimalService();
    private OwnerService ownerService = new OwnerService();

    public void start() {
        Owner owner = new Owner();
        owner.setName("test1");
        ownerService.create(owner);
        List<Owner> owners = ownerService.findAll();
        owners.forEach(System.out::println);

        Animal animal = new Animal();
        animal.setAnimalType(AnimalType.CAT);
        animal.setAlias("Alias");
        animalService.create(animal);
        List<Animal> animals = animalService.findAll();
        animals.forEach(System.out::println);

        String animalId = animals.get(0).getId();
        String ownerId = owners.get(0).getId();
        ownerService.linkAnimal(ownerId, animalId);
        owners = ownerService.findAll();
        owners.forEach(System.out::println);
        animals = animalService.findAll();
        animals.forEach(System.out::println);

        animal = new Animal();
        animal.setAnimalType(AnimalType.DOG);
        animal.setAlias("Alias2");
        animalService.create(animal);
        animals = animalService.findAll();
        animalId = animals.get(1).getId();
        ownerService.linkAnimal(ownerId, animalId);

        owners = ownerService.findAll();
        owners.forEach(System.out::println);
        animals = animalService.findAll();
        animals.forEach(System.out::println);

        ownerService.delete(ownerId);

        System.out.println("after delete");
        owners = ownerService.findAll();
        owners.forEach(System.out::println);
        animals = animalService.findAll();
        animals.forEach(System.out::println);
    }
}

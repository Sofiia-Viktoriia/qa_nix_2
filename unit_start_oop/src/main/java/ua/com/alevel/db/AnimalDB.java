package ua.com.alevel.db;

import ua.com.alevel.entity.Animal;
import ua.com.alevel.entity.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AnimalDB {

    private List<Animal> animals = new ArrayList<>();
    private static final AnimalDB instance = new AnimalDB();

    private AnimalDB() {}

    public static AnimalDB getInstance() {
        return instance;
    }

    public void create(Animal animal) {
        animal.setId(generateId());
        animals.add(animal);
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (animals.stream().anyMatch(animal -> animal.getId().equals(id))) {
            return generateId();
        }
        return id;
    }

    public void update(Animal animal) {
        Animal current = animals.stream().filter(u -> u.getId().equals(animal.getId())).findFirst().get();
        current.setAlias(animal.getAlias());
    }

    public void linkOwner(String ownerId, String animalId) {
        Animal current = animals.stream().filter(u -> u.getId().equals(animalId)).findFirst().get();
        current.setOwnerId(ownerId);
    }

    public void unlinkOwner(String animalId) {
        Animal current = animals.stream().filter(u -> u.getId().equals(animalId)).findFirst().get();
        current.setOwnerId(null);
    }

    public void delete(String id) {
        animals.removeIf(animal -> animal.getId().equals(id));
    }

    public Animal findById(String id) {
        return animals.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }

    public List<Animal> findAll() {
        return animals;
    }

    public List<Animal> findAllByOwners(String ownerId) {
        return animals.stream()
                .filter(animal -> animal.getOwnerId() != null)
                .filter(animal -> animal.getOwnerId().equals(ownerId)).collect(Collectors.toList());
    }
}

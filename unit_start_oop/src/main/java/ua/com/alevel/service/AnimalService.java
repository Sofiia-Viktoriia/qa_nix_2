package ua.com.alevel.service;

import ua.com.alevel.db.AnimalDB;
import ua.com.alevel.entity.Animal;

import java.util.List;

public class AnimalService implements CrudService<Animal> {

    private AnimalDB animalDB = AnimalDB.getInstance();

    @Override
    public void create(Animal animal) {
        animalDB.create(animal);
    }

    @Override
    public void update(Animal animal) {
        animalDB.update(animal);
    }

    @Override
    public void delete(String id) {
        animalDB.delete(id);
    }

    @Override
    public Animal findById(String id) {
        return animalDB.findById(id);
    }

    @Override
    public List<Animal> findAll() {
        return animalDB.findAll();
    }
}

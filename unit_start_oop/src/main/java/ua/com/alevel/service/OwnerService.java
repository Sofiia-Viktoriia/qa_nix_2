package ua.com.alevel.service;

import ua.com.alevel.db.AnimalDB;
import ua.com.alevel.db.OwnerDB;
import ua.com.alevel.entity.Owner;

import java.util.List;

public class OwnerService implements CrudService<Owner> {

    private OwnerDB ownerDB = new OwnerDB();
    private AnimalDB animalDB = AnimalDB.getInstance();

    @Override
    public void create(Owner owner) {
        ownerDB.create(owner);
    }

    @Override
    public void update(Owner owner) {
        ownerDB.update(owner);
    }

    public void linkAnimal(String ownerId, String animalId) {
        if (!ownerDB.existAnimal(animalId, ownerId)) {
            ownerDB.linkAnimal(ownerId, animalId);
            animalDB.linkOwner(ownerId, animalId);
        }
    }

    @Override
    public void delete(String id) {
        Owner owner = findById(id);
        for (String animalId : owner.getAnimalIds()) {
            animalDB.unlinkOwner(animalId);
        }
        ownerDB.delete(id);
    }

    @Override
    public Owner findById(String id) {
        return ownerDB.findById(id);
    }

    @Override
    public List<Owner> findAll() {
        return ownerDB.findAll();
    }
}

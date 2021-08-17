package ua.com.alevel.db;

import ua.com.alevel.entity.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OwnerDB {

    private List<Owner> owners = new ArrayList<>();

    public void create(Owner owner) {
        owner.setId(generateId());
        owners.add(owner);
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (owners.stream().anyMatch(owner -> owner.getId().equals(id))) {
            return generateId();
        }
        return id;
    }

    public void update(Owner owner) {
        Owner current = owners.stream().filter(u -> u.getId().equals(owner.getId())).findFirst().get();
        current.setName(owner.getName());
    }

    public void delete(String id) {
        owners.removeIf(owner -> owner.getId().equals(id));
    }

    public boolean existAnimal(String animalId, String ownerId) {
        Owner current = owners.stream().filter(u -> u.getId().equals(ownerId)).findFirst().get();
        return current.getAnimalIds().isEmpty() ? false : current.getAnimalIds().stream().anyMatch(id -> id.equals(animalId));
    }

    public void linkAnimal(String ownerId, String animalId) {
        Owner current = owners.stream().filter(u -> u.getId().equals(ownerId)).findFirst().get();
        List<String> animalIds = current.getAnimalIds();
        animalIds.add(animalId);
    }

    public Owner findById(String id) {
        return owners.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }

    public List<Owner> findAll() {
        return owners;
    }
}

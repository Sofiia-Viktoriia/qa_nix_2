package ua.com.alevel.entity;

import ua.com.alevel.entity.type.AnimalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Animal extends BaseEntity {

    private String alias;
    private AnimalType animalType;
    private String ownerId;

    public Animal() {}

    public Animal(String alias, AnimalType animalType) {
        this.alias = alias;
        this.animalType = animalType;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + super.getId() + '\'' +
                ", alias='" + alias + '\'' +
                ", animalType=" + animalType +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}

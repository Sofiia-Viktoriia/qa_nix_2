package ua.com.alevel.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Owner extends BaseEntity {

    private String name;
    private List<String> animalIds = new ArrayList<>();

    public Owner() {}

    public Owner(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + super.getId() + '\'' +
                ", name='" + name + '\'' +
                ", animalIds=" + animalIds +
                '}';
    }
}

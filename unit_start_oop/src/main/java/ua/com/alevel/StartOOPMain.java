package ua.com.alevel;

import ua.com.alevel.entity.Animal;
import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.entity.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StartOOPMain {

    public static void main(String[] args) {
        new TestController().start();
        List<BaseEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int r = random.nextInt(2);
            if (r == 0) {
                list.add(new Owner());
            } else {
                list.add(new Animal());
            }
        }
        for (BaseEntity baseEntity : list) {
            if (baseEntity instanceof Owner) {
                System.out.println("Owner - " + baseEntity);
            }
            if (baseEntity instanceof Animal) {
                System.out.println("Animal - " + baseEntity);
            }
        }
    }
}

package ua.com.alevel;

import java.util.Arrays;

public class CollectionMain {

    public static void main(String[] args) {

        MathSet set = new MathSet(new Number[]{3, 1});
        System.out.println(Arrays.toString(set.toArray()));
        set.add(2);
        set.add(5, 2, 1);
        System.out.println(Arrays.toString(set.toArray()));
    }
}

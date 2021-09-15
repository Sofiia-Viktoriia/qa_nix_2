package ua.com.alevel;

import java.util.Arrays;

public class CollectionMain {

    public static void main(String[] args) {

        MathSet set = new MathSet(new Number[]{3, 1});
        System.out.println(Arrays.toString(set.toArray()));
        set.add(2);
        set.add(5, 2, 1);
        System.out.println(Arrays.toString(set.toArray()));
        System.out.println(set.getMax());
        System.out.println(set.getMin());
        System.out.println(set.getAverage());
        System.out.println(set.getMedian());
        System.out.println(Arrays.toString(set.toArray(1, 3)));
        System.out.println(Arrays.toString(set.cut(2, 3).toArray()));
        set.clear(new Number[]{5, 1});
        System.out.println(Arrays.toString(set.toArray()));
        set.add(5, 1, 7, 3, 5, 3, 5, 7, 5, 5, 8, 9, 0, 23, 6, 21, 63, 15, 19);
        System.out.println(Arrays.toString(set.toArray()));
        set.sortAsc();
        System.out.println(Arrays.toString(set.toArray()));
        set.sortDesc();
        System.out.println(Arrays.toString(set.toArray()));
        set.sortAsc(7);
        System.out.println(Arrays.toString(set.toArray()));
        set.sortDesc(0, 5);
        System.out.println(Arrays.toString(set.toArray()));
        set.intersection(new MathSet(new Number[] {9, 1, 4, 5}));
        System.out.println(Arrays.toString(set.toArray()));
    }
}

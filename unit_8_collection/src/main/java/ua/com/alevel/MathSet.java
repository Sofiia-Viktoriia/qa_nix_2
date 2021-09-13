package ua.com.alevel;

public class MathSet {

    private Number[] set;
    private int capacity;
    private int size;

    MathSet() {
        this.set = new Number[10];
        this.capacity = 10;
        this.size = 0;
    }

    MathSet(int capacity) {
        this.set = new Number[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    MathSet(Number[] numbers) {
        this.set = new Number[10];
        this.capacity = 10;
        this.size = 0;
        for (Number num: numbers) {
            add(num);
        }
    }

    MathSet(Number[] ... numbers) {
        this.set = new Number[10];
        this.capacity = 10;
        this.size = 0;
        for (Number[] number: numbers) {
            for (Number num: number) {
                add(num);
            }
        }
    }

    MathSet(MathSet numbers) {
        this.set = numbers.toArray();
        this.capacity = this.set.length;
        this.size = this.set.length;
    }

    MathSet(MathSet ... numbers) {
        this.set = new Number[10];
        this.capacity = 10;
        this.size = 0;
        join(numbers);
    }

    public void add(Number n) {
        if (!contains(n)) {
            if (capacity > size) {
                set[size] = n;
                size++;
            } else {
                Number[] temp = set;
                set = new Number[(capacity * 3 / 2) + 1];
                capacity = (capacity * 3 / 2) + 1;
                add(n);
            }
        }
    }

    public void add(Number ... n) {
        for (Number num: n) {
            add(num);
        }
    }

    public void join(MathSet ms) { }
    public void join(MathSet ... ms) { }
    public void intersection(MathSet ms) { }
    public void intersection (MathSet ... ms) { }
    public void sortDesc() { }
    public void sortDesc(int firstIndex, int lastIndex) { }
    public void sortDesc(Number value) { }
    public void sortAsc() { }
    public void sortAsc(int firstIndex, int lastIndex) { }
    public void sortAsc(Number value) { }

    public Number get(int index) {
        if (index >= size || index < 0) {
            System.out.println("Wrong index");
            return null;
        } else {
            return set[index];
        }
    }

    public Number getMax() { return null; }
    public Number getMin() { return null; }
    public Number getAverage() { return null; }
    public Number getMedian() { return null; }

    public Number[] toArray() {
        if (capacity == size) {
            return set;
        } else {
            Number[] temp = new Number[size];
            for (int i = 0; i < size; i++) {
                temp[i] = set[i];
            }
            return temp;
        }
    }

    public Number[] toArray(int firstIndex, int lastIndex) { return null; }
    public MathSet cut(int firstIndex, int lastIndex) { return null; }

    public void clear() {
        set = new Number[10];
        capacity = 10;
        size = 0;
    }

    public void clear(Number[] numbers) { }

    private boolean contains(Number n) {
        for (Number num: set) {
            if (num != null && num.doubleValue() == n.doubleValue()) {
                return true;
            }
        }
        return false;
    }
}

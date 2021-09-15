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
        if (!contains(set, n)) {
            if (capacity > size) {
                set[size] = n;
                size++;
            } else {
                Number[] temp = set;
                set = new Number[(capacity * 3 / 2) + 1];
                capacity = (capacity * 3 / 2) + 1;
                for (int i = 0; i < size; i++) {
                    set[i] = temp[i];
                }
                add(n);
            }
        }
    }

    public void add(Number ... n) {
        for (Number num: n) {
            add(num);
        }
    }

    public void join(MathSet ms) {
        Number[] temp = ms.toArray();
        for (Number num: temp) {
            add(num);
        }
    }

    public void join(MathSet ... ms) {
        for (MathSet mathSet: ms) {
            join(ms);
        }
    }

    public void intersection(MathSet ms) {
        Number[] temp = ms.toArray();
        MathSet mathSet = new MathSet();
        for (int i = 0; i < size; i++) {
            if(!contains(temp, set[i])) {
                mathSet.add(set[i]);
            }
        }
        clear(mathSet.toArray());
    }

    public void intersection (MathSet ... ms) {
        for (MathSet set: ms) {
            intersection(ms);
        }
    }

    public void sortDesc() {
        quickSortDesc(set, 0, size - 1);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        if (firstIndex <= lastIndex && firstIndex >= 0 && lastIndex < size) {
            quickSortDesc(set, firstIndex, lastIndex);
        } else {
            System.out.println("Wrong indexes");
        }
    }

    public void sortDesc(Number value) {
        if (getIndex(value) != -1) {
            quickSortDesc(set, getIndex(value), size - 1);
        } else {
            System.out.println("No such element");
        }
    }

    public void sortAsc() {
        quickSortAsc(set, 0, size - 1);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if (firstIndex <= lastIndex && firstIndex >= 0 && lastIndex < size) {
            quickSortAsc(set, firstIndex, lastIndex);
        } else {
            System.out.println("Wrong indexes");
        }
    }

    public void sortAsc(Number value) {
        if (getIndex(value) != -1) {
            quickSortAsc(set, getIndex(value), size - 1);
        } else {
            System.out.println("No such element");
        }
    }

    public Number get(int index) {
        if (index >= size || index < 0) {
            System.out.println("Wrong index");
            return null;
        } else {
            return set[index];
        }
    }

    public Number getMax() {
        if (size > 0) {
            Number max = set[0];
            for (int i = 1; i < size; i++) {
                if (set[i].doubleValue() > max.doubleValue()) {
                    max = set[i];
                }
            }
            return max;
        } else {
            System.out.println("There is no elements");
            return null;
        }
    }

    public Number getMin() {
        if (size > 0) {
            Number min = set[0];
            for (int i = 1; i < size; i++) {
                if (set[i].doubleValue() < min.doubleValue()) {
                    min = set[i];
                }
            }
            return min;
        } else {
            System.out.println("There is no elements");
            return null;
        }
    }

    public Number getAverage() {
        if (size > 0) {
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                sum = sum + set[i].doubleValue();
            }
            return sum / size;
        } else {
            System.out.println("There is no elements");
            return null;
        }
    }

    public Number getMedian() {
        if (size > 0) {
            Number[] temp = toArray();
            quickSortAsc(temp, 0, size - 1);
            if (size % 2 == 0) {
                return (temp[size / 2 - 1].doubleValue() + temp[size / 2].doubleValue()) / 2;
            } else {
                return temp[size / 2 + 1];
            }
        } else {
            System.out.println("There is no elements");
            return null;
        }
    }

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

    public Number[] toArray(int firstIndex, int lastIndex) {
        if (firstIndex <= lastIndex && firstIndex >= 0 && lastIndex < size) {
            Number[] temp = new Number[lastIndex - firstIndex + 1];
            for (int i = firstIndex, j = 0; i <= lastIndex; i++, j++) {
                temp[j] = set[i];
            }
            return temp;
        } else {
            System.out.println("Wrong indexes");
            return null;
        }
    }

    public MathSet cut(int firstIndex, int lastIndex) {
        if (firstIndex <= lastIndex && firstIndex >= 0 && lastIndex < size) {
            Number[] temp = new Number[lastIndex - firstIndex + 1];
            for (int i = firstIndex, j = 0; i <= lastIndex; i++, j++) {
                temp[j] = set[i];
            }
            return new MathSet(temp);
        } else {
            System.out.println("Wrong indexes");
            return null;
        }
    }

    public void clear() {
        set = new Number[10];
        capacity = 10;
        size = 0;
    }

    public void clear(Number[] numbers) {
        for (Number num: numbers) {
            int initSize = size;
            for (int i = 0; i < initSize; i++) {
                if (num != null && set[i].doubleValue() == num.doubleValue()) {
                    delete(i);
                    break;
                }
            }
        }
    }

    private boolean contains(Number[] array, Number n) {
        if (n != null) {
            for (Number num: array) {
                if (num != null && num.doubleValue() == n.doubleValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void delete(int index) {
        for (int i = index; i < size - 1; i++) {
            set[i] = set[i + 1];
        }
        set[size - 1] = null;
        size--;
    }

    private void quickSortAsc(Number[] nums, int low, int high) {
        if (nums.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Number base = nums[middle];

        int i = low, j = high;
        while (i <= j) {
            while (nums[i].doubleValue() < base.doubleValue()) {
                i++;
            }

            while (nums[j].doubleValue() > base.doubleValue()) {
                j--;
            }

            if (i <= j) {
                Number temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSortAsc(nums, low, j);

        if (high > i)
            quickSortAsc(nums, i, high);
    }

    private void quickSortDesc(Number[] nums, int low, int high) {
        if (nums.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        Number base = nums[middle];

        int i = low, j = high;
        while (i <= j) {
            while (nums[i].doubleValue() > base.doubleValue()) {
                i++;
            }

            while (nums[j].doubleValue() < base.doubleValue()) {
                j--;
            }

            if (i <= j) {
                Number temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSortDesc(nums, low, j);

        if (high > i)
            quickSortDesc(nums, i, high);
    }

    private int getIndex(Number n) {
        for (int i = 0; i < size; i++) {
            if (set[i].doubleValue() == n.doubleValue()) {
                return i;
            }
        }
        return -1;
    }
}

package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CollectionMain {

    public static void main(String[] args) {

        int choice = 1;
        MathSet set = null;
        while (choice != 0) {
            System.out.println("\nPlease, choose the option:" +
                    "\n0 - Exit" +
                    "\n1 - Create MathSet" +
                    "\n2 - Add elements" +
                    "\n3 - Get intersection" +
                    "\n4 - Sort set" +
                    "\n5 - Get element by index" +
                    "\n6 - Get max element" +
                    "\n7 - Get min element" +
                    "\n8 - Get average" +
                    "\n9 - Get median" +
                    "\n10 - Print as an Array" +
                    "\n11 - Cut the set" +
                    "\n12 - Clear the set");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                choice = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (choice) {
                case 0: {
                    System.out.println("Exiting...");
                }
                break;
                case 1: {
                    int choose = 0;
                    System.out.println("\n1 - Create" +
                            "\n2 - Create with capacity" +
                            "\n3 - Create with elements");
                    try {
                        choose = Integer.parseInt(bufferedReader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (choose == 1) {
                        set = new MathSet();
                    } else if (choose == 2) {
                        try {
                            System.out.println("Please, enter the capacity");
                            set = new MathSet(Integer.parseInt(bufferedReader.readLine()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (choose == 3) {
                        int type = 0;
                        int amount = 0;
                        System.out.println("Please, choose the type of elements:" +
                                "\n1 - Byte" +
                                "\n2 - Short" +
                                "\n3 - Integer" +
                                "\n4 - Long" +
                                "\n5 - Float" +
                                "\n6 - Double");
                        try {
                            type = Integer.parseInt(bufferedReader.readLine());
                            System.out.println("Please, enter the amount of elements");
                            amount = Integer.parseInt(bufferedReader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (amount >= 0) {
                            Number[] array = new Number[amount];
                            while (amount > 0) {
                                System.out.println("Please, enter the value");
                                try {
                                    switch (type) {
                                        case 1:
                                            array[array.length - amount] = Byte.parseByte(bufferedReader.readLine());
                                            break;
                                        case 2:
                                            array[array.length - amount] = Short.parseShort(bufferedReader.readLine());
                                            break;
                                        case 3:
                                            array[array.length - amount] = Integer.parseInt(bufferedReader.readLine());
                                            break;
                                        case 4:
                                            array[array.length - amount] = Long.parseLong(bufferedReader.readLine());
                                            break;
                                        case 5:
                                            array[array.length - amount] = Float.parseFloat(bufferedReader.readLine());
                                            break;
                                        case 6:
                                            array[array.length - amount] = Double.parseDouble(bufferedReader.readLine());
                                            break;
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                amount--;
                            }
                            set = new MathSet(array);
                            System.out.println(Arrays.toString(set.toArray()));
                        }
                    }
                }
                break;
                case 2: {
                    if (set != null) {
                        int type = 0;
                        int amount = 0;
                        System.out.println("Please, choose the type of elements:" +
                                "\n1 - Byte" +
                                "\n2 - Short" +
                                "\n3 - Integer" +
                                "\n4 - Long" +
                                "\n5 - Float" +
                                "\n6 - Double");
                        try {
                            type = Integer.parseInt(bufferedReader.readLine());
                            System.out.println("Please, enter the amount of elements");
                            amount = Integer.parseInt(bufferedReader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (amount >= 0) {
                            while (amount > 0) {
                                System.out.println("Please, enter the value");
                                try {
                                    switch (type) {
                                        case 1:
                                            set.add(Byte.parseByte(bufferedReader.readLine()));
                                            break;
                                        case 2:
                                            set.add(Short.parseShort(bufferedReader.readLine()));
                                            break;
                                        case 3:
                                            set.add(Integer.parseInt(bufferedReader.readLine()));
                                            break;
                                        case 4:
                                            set.add(Long.parseLong(bufferedReader.readLine()));
                                            break;
                                        case 5:
                                            set.add(Float.parseFloat(bufferedReader.readLine()));
                                            break;
                                        case 6:
                                            set.add(Double.parseDouble(bufferedReader.readLine()));
                                            break;
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                amount--;
                            }
                            System.out.println(Arrays.toString(set.toArray()));
                        }
                    } else {
                        System.out.println("You should create a set");
                    }
                }
                break;
                case 3: {
                    if (set != null) {
                        int type = 0;
                        int amountOfElements = 0;
                        int amountOfSets = 0;
                        try {
                            System.out.println("Please, enter the amount of sets to intersect with");
                            amountOfSets = Integer.parseInt(bufferedReader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < amountOfSets; i++) {
                            System.out.println("Please, choose the type of elements:" +
                                    "\n1 - Byte" +
                                    "\n2 - Short" +
                                    "\n3 - Integer" +
                                    "\n4 - Long" +
                                    "\n5 - Float" +
                                    "\n6 - Double");
                            try {
                                type = Integer.parseInt(bufferedReader.readLine());
                                System.out.println("Please, enter the amount of elements");
                                amountOfElements = Integer.parseInt(bufferedReader.readLine());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (amountOfElements >= 0) {
                                Number[] array = new Number[amountOfElements];
                                while (amountOfElements > 0) {
                                    System.out.println("Please, enter the value");
                                    try {
                                        switch (type) {
                                            case 1:
                                                array[array.length - amountOfElements] = Byte.parseByte(bufferedReader.readLine());
                                                break;
                                            case 2:
                                                array[array.length - amountOfElements] = Short.parseShort(bufferedReader.readLine());
                                                break;
                                            case 3:
                                                array[array.length - amountOfElements] = Integer.parseInt(bufferedReader.readLine());
                                                break;
                                            case 4:
                                                array[array.length - amountOfElements] = Long.parseLong(bufferedReader.readLine());
                                                break;
                                            case 5:
                                                array[array.length - amountOfElements] = Float.parseFloat(bufferedReader.readLine());
                                                break;
                                            case 6:
                                                array[array.length - amountOfElements] = Double.parseDouble(bufferedReader.readLine());
                                                break;
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    amountOfElements--;
                                }
                                set.intersection(new MathSet(array));
                            }
                            System.out.println(Arrays.toString(set.toArray()));
                        }
                    } else {
                        System.out.println("You should create a set");
                    }
                }
                break;
                case 4: {
                    if (set != null) {
                        int choose = 0;
                        int typeSort = 0;
                        try {
                            System.out.println("1 - Ascending\n2 - Descending");
                            choose = Integer.parseInt(bufferedReader.readLine());
                            System.out.println("1 - Sort all\n2 - Sort by indexes\n3 - Sort from value");
                            typeSort = Integer.parseInt(bufferedReader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (typeSort == 1) {
                            if (choose == 1) {
                                set.sortAsc();
                            } else {
                                set.sortDesc();
                            }
                        } else if (typeSort == 2) {
                            int firstIndex = -1;
                            int lastIndex = -1;
                            try {
                                System.out.println("Please, enter the first index");
                                firstIndex = Integer.parseInt(bufferedReader.readLine());
                                System.out.println("Please, enter the last index");
                                lastIndex = Integer.parseInt(bufferedReader.readLine());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (choose == 1) {
                                set.sortAsc(firstIndex, lastIndex);
                            } else {
                                set.sortDesc(firstIndex, lastIndex);
                            }
                        } else if (typeSort == 3) {
                            double value = -1;
                            try {
                                System.out.println("Please, enter the value");
                                value = Double.parseDouble(bufferedReader.readLine());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (choose == 1) {
                                set.sortAsc(value);
                            } else {
                                set.sortDesc(value);
                            }
                        }
                        System.out.println(Arrays.toString(set.toArray()));
                    } else {
                        System.out.println("You should create a set");
                    }
                }
                break;
                case 5: {
                    if (set != null) {
                        int index = -1;
                        try {
                            System.out.println("Please, enter the index");
                            index = Integer.parseInt(bufferedReader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Value: " + set.get(index));
                    } else {
                        System.out.println("You should create a set");
                    }
                }
                break;
                case 6: {
                    if (set != null) {
                        System.out.println("Max value: " + set.getMax());
                    } else {
                        System.out.println("You should create a set");
                    }
                }
                break;
                case 7: {
                    if (set != null) {
                        System.out.println("Min value: " + set.getMin());
                    } else {
                        System.out.println("You should create a set");
                    }
                }
                break;
                case 8: {
                    if (set != null) {
                        System.out.println("Average value: " + set.getAverage());
                    } else {
                        System.out.println("You should create a set");
                    }
                }
                break;
                case 9: {
                    if (set != null) {
                        System.out.println("Median value: " + set.getMedian());
                    } else {
                        System.out.println("You should create a set");
                    }
                }
                break;
                case 10: {
                    if (set != null) {
                        int choose = -1;
                        try {
                            System.out.println("1 - print all\n2- print by indexes");
                            choose = Integer.parseInt(bufferedReader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (choose == 1) {
                            System.out.println(Arrays.toString(set.toArray()));
                        } else {
                            int firstIndex = -1;
                            int lastIndex = -1;
                            try {
                                System.out.println("Please, enter the first index");
                                firstIndex = Integer.parseInt(bufferedReader.readLine());
                                System.out.println("Please, enter the last index");
                                lastIndex = Integer.parseInt(bufferedReader.readLine());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Arrays.toString(set.toArray(firstIndex, lastIndex)));
                        }
                    } else {
                        System.out.println("You should create a set");
                    }
                }
                break;
                case 11: {
                    if (set != null) {
                        int firstIndex = -1;
                        int lastIndex = -1;
                        try {
                            System.out.println("Please, enter the first index");
                            firstIndex = Integer.parseInt(bufferedReader.readLine());
                            System.out.println("Please, enter the last index");
                            lastIndex = Integer.parseInt(bufferedReader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Arrays.toString(set.cut(firstIndex, lastIndex).toArray()));
                    } else {
                        System.out.println("You should create a set");
                    }
                }
                break;
                case 12: {
                    if (set != null) {
                        int choose = -1;
                        try {
                            System.out.println("1 - clear all\n2- clear certain values");
                            choose = Integer.parseInt(bufferedReader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (choose == 1) {
                            set.clear();
                            System.out.println(Arrays.toString(set.toArray()));
                        } else if (choose == 2) {
                            int type = 0;
                            int amount = 0;
                            System.out.println("Please, choose the type of elements:" +
                                    "\n1 - Byte" +
                                    "\n2 - Short" +
                                    "\n3 - Integer" +
                                    "\n4 - Long" +
                                    "\n5 - Float" +
                                    "\n6 - Double");
                            try {
                                type = Integer.parseInt(bufferedReader.readLine());
                                System.out.println("Please, enter the amount of elements");
                                amount = Integer.parseInt(bufferedReader.readLine());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (amount >= 0) {
                                Number[] array = new Number[amount];
                                while (amount > 0) {
                                    System.out.println("Please, enter the value");
                                    try {
                                        switch (type) {
                                            case 1:
                                                array[array.length - amount] = Byte.parseByte(bufferedReader.readLine());
                                                break;
                                            case 2:
                                                array[array.length - amount] = Short.parseShort(bufferedReader.readLine());
                                                break;
                                            case 3:
                                                array[array.length - amount] = Integer.parseInt(bufferedReader.readLine());
                                                break;
                                            case 4:
                                                array[array.length - amount] = Long.parseLong(bufferedReader.readLine());
                                                break;
                                            case 5:
                                                array[array.length - amount] = Float.parseFloat(bufferedReader.readLine());
                                                break;
                                            case 6:
                                                array[array.length - amount] = Double.parseDouble(bufferedReader.readLine());
                                                break;
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    amount--;
                                }
                                set.clear(array);
                                System.out.println(Arrays.toString(set.toArray()));
                            }
                        }
                    } else {
                        System.out.println("You should create a set");
                    }
                }
                break;
                default: {
                    System.out.println("Please, choose the option from the menu.");
                }
            }
        }
    }

    private int getType(BufferedReader bufferedReader) {
        System.out.println("Please, choose the type of elements:" +
                "\n1 - Byte" +
                "\n2 - Short" +
                "\n3 - Integer" +
                "\n4 - Long" +
                "\n5 - Float" +
                "\n6 - Double");
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

import java.util.Random;

public class DataGenerator {

    private static final Random random = new Random();

    // Random data
    public static Integer[] randomArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    // Sorted data (ascending)
    public static Integer[] sortedArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    // Reverse sorted data (descending)
    public static Integer[] reverseSortedArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }

    // Nearly sorted (10% random swaps)
    public static Integer[] nearlySortedArray(int size) {
        Integer[] array = sortedArray(size);
        int swaps = size / 10;

        for (int i = 0; i < swaps; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);

            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
        return array;
    }

    // Many duplicates (10–20 unique values)
    public static Integer[] manyDuplicatesArray(int size) {
        Integer[] array = new Integer[size];
        int uniqueValues = 10 + random.nextInt(11);

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(uniqueValues);
        }
        return array;
    }
}

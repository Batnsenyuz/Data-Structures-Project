import java.util.Random;

public class QuickSort<T extends Comparable<T>> implements SortAlgorithm<T> {

    private long comparisons;
    private long swaps;
    private final Random random = new Random();

    @Override
    public SortResult sort(T[] array) {

        comparisons = 0;
        swaps = 0;

        long startTime = System.currentTimeMillis();

        quickSort(array, 0, array.length - 1);

        long endTime = System.currentTimeMillis();

        return new SortResult(
                comparisons,
                swaps,
                endTime - startTime
        );
    }

    private void quickSort(T[] array, int low, int high) {

        if (low >= high) {
            return;
        }

        int pivotIndex = partition(array, low, high);

        quickSort(array, low, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, high);
    }

    private int partition(T[] array, int low, int high) {

        int randomIndex = low + random.nextInt(high - low + 1);
        swap(array, randomIndex, high);

        T pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;

            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(T[] array, int i, int j) {

        if (i != j) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            swaps++;
        }
    }

    @Override
    public String getName() {
        return "Quick Sort (Random Pivot)";
    }
}

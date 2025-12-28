import java.util.Random;

public class QuickSort3Way<T extends Comparable<T>> implements SortAlgorithm<T> {

    private long comparisons;
    private long swaps;
    private final Random random = new Random();

    @Override
    public SortResult sort(T[] array) {

        comparisons = 0;
        swaps = 0;

        long startTime = System.currentTimeMillis();

        quickSort3Way(array, 0, array.length - 1);

        long endTime = System.currentTimeMillis();

        return new SortResult(
                comparisons,
                swaps,
                endTime - startTime
        );
    }

    private void quickSort3Way(T[] array, int low, int high) {

        if (low >= high) {
            return;
        }

        int pivotIndex = low + random.nextInt(high - low + 1);
        T pivot = array[pivotIndex];

        int lt = low;      // array[low .. lt-1] < pivot
        int gt = high;     // array[gt+1 .. high] > pivot
        int i = low;

        while (i <= gt) {
            comparisons++;
            int cmp = array[i].compareTo(pivot);

            if (cmp < 0) {
                swap(array, lt++, i++);
            } else if (cmp > 0) {
                swap(array, i, gt--);
            } else {
                i++;
            }
        }

        quickSort3Way(array, low, lt - 1);
        quickSort3Way(array, gt + 1, high);
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
        return "3-Way Quick Sort";
    }
}

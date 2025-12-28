public class SelectionSort<T extends Comparable<T>> implements SortAlgorithm<T> {

    @Override
    public SortResult sort(T[] array) {

        long comparisons = 0;
        long swaps = 0;

        long startTime = System.currentTimeMillis();

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                comparisons++;

                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Swap only if a smaller element was found
            if (minIndex != i) {
                swap(array, i, minIndex);
                swaps++;
            }
        }

        long endTime = System.currentTimeMillis();

        return new SortResult(
                comparisons,
                swaps,
                endTime - startTime
        );
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }
}

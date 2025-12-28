public class MergeSort<T extends Comparable<T>> implements SortAlgorithm<T> {

    private long comparisons;
    private long moves;

    @Override
    public SortResult sort(T[] array) {

        comparisons = 0;
        moves = 0;

        long startTime = System.currentTimeMillis();

        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[array.length];

        mergeSort(array, temp, 0, array.length - 1);

        long endTime = System.currentTimeMillis();

        return new SortResult(
                comparisons,
                moves,
                endTime - startTime
        );
    }

    private void mergeSort(T[] array, T[] temp, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(array, temp, left, mid);
        mergeSort(array, temp, mid + 1, right);
        merge(array, temp, left, mid, right);
    }

    private void merge(T[] array, T[] temp, int left, int mid, int right) {

        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
            moves++;
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            comparisons++;

            if (temp[i].compareTo(temp[j]) <= 0) {
                array[k++] = temp[i++];
                moves++;
            } else {
                array[k++] = temp[j++];
                moves++;
            }
        }

        while (i <= mid) {
            array[k++] = temp[i++];
            moves++;
        }

        // Right half remaining elements are already in place
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }
}

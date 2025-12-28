public class InsertionSort<T extends Comparable<T>> implements SortAlgorithm<T> {

    @Override
    public SortResult sort(T[] array) {

        long comparisons = 0;
        long swaps = 0; // Here swaps represent data movements

        long startTime = System.currentTimeMillis();

        int n = array.length;

        for (int i = 1; i < n; i++) {

            T key = array[i];
            int j = i - 1;

            /*
             * Move elements that are greater than key
             * one position ahead to make space for key
             */
            while (j >= 0) {
                comparisons++;

                if (array[j].compareTo(key) > 0) {
                    array[j + 1] = array[j];
                    swaps++; // data movement
                    j--;
                } else {
                    break;
                }
            }

            array[j + 1] = key;
            swaps++; // insertion of key
        }

        long endTime = System.currentTimeMillis();

        return new SortResult(
                comparisons,
                swaps,
                endTime - startTime
        );
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}

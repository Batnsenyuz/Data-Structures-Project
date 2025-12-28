public interface SortAlgorithm<T extends Comparable<T>> {

    /**
     * Sorts the given array and returns performance metrics.
     *
     * @param array the array to sort
     * @return SortResult containing comparisons, swaps, and execution time
     */
    SortResult sort(T[] array);

    /**
     * @return the name of the sorting algorithm
     */
    String getName();
}

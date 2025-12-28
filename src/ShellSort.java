public class ShellSort<T extends Comparable<T>> implements SortAlgorithm<T> {

    public enum GapSequence {
        SHELL,
        KNUTH
    }

    private final GapSequence gapSequence;

    public ShellSort(GapSequence gapSequence) {
        this.gapSequence = gapSequence;
    }

    @Override
    public SortResult sort(T[] array) {

        long comparisons = 0;
        long swaps = 0; // data movements

        long startTime = System.currentTimeMillis();
        int n = array.length;

        int[] gaps = generateGaps(n);

        for (int gap : gaps) {

            for (int i = gap; i < n; i++) {

                T temp = array[i];
                int j = i;

                while (j >= gap) {
                    comparisons++;

                    if (array[j - gap].compareTo(temp) > 0) {
                        array[j] = array[j - gap];
                        swaps++;
                        j -= gap;
                    } else {
                        break;
                    }
                }

                array[j] = temp;
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

    private int[] generateGaps(int n) {

        if (gapSequence == GapSequence.SHELL) {
            return generateShellGaps(n);
        } else {
            return generateKnuthGaps(n);
        }
    }

    /*
     * Shell's original gap sequence: n/2, n/4, ..., 1
     */
    private int[] generateShellGaps(int n) {

        int size = 0;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            size++;
        }

        int[] gaps = new int[size];
        int index = 0;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            gaps[index++] = gap;
        }

        return gaps;
    }

    /*
     * Knuth's gap sequence: (3^k - 1) / 2
     */
    private int[] generateKnuthGaps(int n) {

        int gap = 1;
        int count = 0;

        while (gap < n) {
            gap = gap * 3 + 1;
            count++;
        }

        int[] gaps = new int[count];
        int index = count - 1;

        while (gap > 1) {
            gap = (gap - 1) / 3;
            gaps[index--] = gap;
        }

        return gaps;
    }

    @Override
    public String getName() {
        return "Shell Sort (" + gapSequence + " sequence)";
    }
}

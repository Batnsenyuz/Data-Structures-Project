public class SortResult {

    private long comparisons;
    private long swaps;
    private long timeMillis;

    public SortResult(long comparisons, long swaps, long timeMillis) {
        this.comparisons = comparisons;
        this.swaps = swaps;
        this.timeMillis = timeMillis;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    @Override
    public String toString() {
        return "Time(ms): " + timeMillis +
                ", Comparisons: " + comparisons +
                ", Swaps/Moves: " + swaps;
    }
}

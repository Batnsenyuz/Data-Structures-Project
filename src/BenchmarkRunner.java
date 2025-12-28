public class BenchmarkRunner {

    private static final int RUNS = 5;

    public static void runBenchmark(
            SortAlgorithm<Integer> algorithm,
            Integer[] originalArray,
            String dataType,
            int size
    ) {

        long totalTime = 0;
        long totalComparisons = 0;
        long totalSwaps = 0;

        for (int i = 0; i < RUNS; i++) {

            Integer[] arrayCopy = originalArray.clone();
            SortResult result = algorithm.sort(arrayCopy);

            totalTime += result.getTimeMillis();
            totalComparisons += result.getComparisons();
            totalSwaps += result.getSwaps();
        }

        long avgTime = totalTime / RUNS;
        long avgComparisons = totalComparisons / RUNS;
        long avgSwaps = totalSwaps / RUNS;

        // Console output
        System.out.println(
                algorithm.getName() + " | " + dataType +
                        " | Size: " + size +
                        " | Avg Time(ms): " + avgTime +
                        " | Avg Comparisons: " + avgComparisons +
                        " | Avg Swaps/Moves: " + avgSwaps
        );

        // CSV output
        CSVWriter.writeRow(
                algorithm.getName(),
                dataType,
                size,
                avgTime,
                avgComparisons,
                avgSwaps
        );
    }
}

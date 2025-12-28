public class Main {

    public static void main(String[] args) {

        CSVWriter.writeHeader();

        int[] sizes = {1000, 5000, 10000};

        SortAlgorithm<Integer>[] algorithms = new SortAlgorithm[]{
                new SelectionSort<>(),
                new InsertionSort<>(),
                new ShellSort<>(ShellSort.GapSequence.SHELL),
                new ShellSort<>(ShellSort.GapSequence.KNUTH),
                new MergeSort<>(),
                new QuickSort<>(),
                new QuickSort3Way<>()
        };

        for (int size : sizes) {

            System.out.println("\n========== ARRAY SIZE: " + size + " ==========");

            Integer[] random = DataGenerator.randomArray(size);
            Integer[] sorted = DataGenerator.sortedArray(size);
            Integer[] reverse = DataGenerator.reverseSortedArray(size);
            Integer[] nearly = DataGenerator.nearlySortedArray(size);
            Integer[] duplicates = DataGenerator.manyDuplicatesArray(size);

            for (SortAlgorithm<Integer> algorithm : algorithms) {

                BenchmarkRunner.runBenchmark(algorithm, random, "Random", size);
                BenchmarkRunner.runBenchmark(algorithm, sorted, "Sorted", size);
                BenchmarkRunner.runBenchmark(algorithm, reverse, "Reverse", size);
                BenchmarkRunner.runBenchmark(algorithm, nearly, "Nearly Sorted", size);
                BenchmarkRunner.runBenchmark(algorithm, duplicates, "Duplicates", size);

                System.out.println();
            }
        }

        System.out.println("\nBenchmark completed. Results saved to benchmark_results.csv");
    }
}

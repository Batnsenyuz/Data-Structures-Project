import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

    private static final String FILE_NAME = "benchmark_results.csv";

    public static void writeHeader() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.append("Algorithm,DataType,ArraySize,AvgTime(ms),AvgComparisons,AvgSwaps\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRow(
            String algorithm,
            String dataType,
            int size,
            long time,
            long comparisons,
            long swaps
    ) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.append(algorithm).append(",")
                    .append(dataType).append(",")
                    .append(String.valueOf(size)).append(",")
                    .append(String.valueOf(time)).append(",")
                    .append(String.valueOf(comparisons)).append(",")
                    .append(String.valueOf(swaps)).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

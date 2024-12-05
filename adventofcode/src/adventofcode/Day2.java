package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {

    public static int safeReports(int[][] reports) {
        int sum = 0;
        for (int i = 0; i < reports.length; i++) {
            if (isSafe(reports[i])) {
                sum++;
            }
        }
        return sum;
    }

    private static boolean isSafe(int[] report) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < report.length-1; i++) {
            int previous = report[i];
            int current = report[i+1];
            int difference = Math.abs(previous - current);
            if (difference > 3 || difference < 1) {
                return false;
            }
            increasing = increasing && (previous < current);
            decreasing = decreasing && (previous > current);
        }
        return increasing || decreasing;
    }

    public static int[][] readArrayFile(String filename) throws IOException {
        List<int[]> tempArrays = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int[] numbers = Arrays.stream(line.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                tempArrays.add(numbers);
            }
        }
        return tempArrays.toArray(new int[0][]);
    }

    public static void main(String[] args) throws IOException {
        int[][] input = readArrayFile("src/adventofcode/input2");
        System.out.println(Day2.safeReports(input));
    }
}

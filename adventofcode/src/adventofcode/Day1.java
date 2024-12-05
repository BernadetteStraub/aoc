package adventofcode;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1 {

    public int totalDistance(int[] list1, int[] list2) {
        Arrays.sort(list1);
        Arrays.sort(list2);
        int sum = 0;
        for (int i = 0; i < list1.length; i++) {
            sum += Math.abs(list1[i] - list2[i]);
        }
        return sum;
    }

    public int similarityScore(int[] list1, int[] list2) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            int current = list2[i];
            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        for (int i = 0; i < list1.length; i++) {
            int current = list1[i];
            int occurance = map.getOrDefault(current, 0);
            sum += current*occurance;
        }
        return sum;
    }

    public static int[][] readArrays(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            int[][] arrays = new int[2][lines.size()];

            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split("\\s+");
                arrays[0][i] = Integer.parseInt(parts[0]);
                arrays[1][i] = Integer.parseInt(parts[1]);
            }
            return arrays;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        int[][] input = readArrays("src/adventofcode/input1");
        int[] a = input[0];
        int[] b = input[1];
        Day1 day1 = new Day1();
//        System.out.println(day1.totalDistance(a, b));
        System.out.println(day1.similarityScore(a, b));
    }
}

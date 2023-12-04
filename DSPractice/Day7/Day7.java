import java.util.*;
import java.util.stream.*;

/**
 * Day7
 */
public class Day7 {

    public static void main(String[] args) {
        Day7 day7 = new Day7();
        List<Integer> gasAvailableInStation = Arrays.asList(237, 573, 278, 782, 819, 548, 14, 670, 81, 178, 448, 889,
                200, 541, 582, 111, 718, 236, 292, 850, 536, 654, 230, 551, 917, 788, 531, 26, 206, 960, 381, 183, 207,
                44, 141, 252, 74, 890, 857, 834, 396, 569, 597, 538, 370, 876, 481, 307, 643, 138, 652, 676, 340, 590,
                565, 857, 584, 275, 703, 508, 388, 454, 944, 670);
        List<Integer> gasNeededToTravelNextStation = Arrays.asList(316, 803, 374, 899, 361, 548, 430, 366, 137, 993,
                751, 9, 52, 774, 449, 533, 870, 271, 829, 232, 529, 9, 167, 738, 779, 89, 515, 67, 649, 831, 508, 397,
                914, 236, 134, 914, 129, 77, 372, 921, 527, 588, 249, 275, 23, 793, 321, 264, 30, 360, 29, 27, 96, 150,
                746, 338, 921, 846, 719, 193, 565, 236, 92, 453);
        System.out.println(day7.gasStation(gasAvailableInStation, gasNeededToTravelNextStation));
        int[][] inputMatrix = { { 1, 1, 1 }, { 0, 1, 1 }, { 1, 0, 0 } };
        System.out.println(day7.maxRectangleArea(inputMatrix));
    }

    private int gasStation(List<Integer> gasAvailableInStation, List<Integer> gasNeededToTravelNextStation) {
        int startPoint = 0;
        int gasAvailable = 0;
        int gasShortage = 0;
        int totalStation = gasAvailableInStation.size();
        for (int i = 0; i < totalStation; i++) {
            gasAvailable += (gasAvailableInStation.get(i) - gasNeededToTravelNextStation.get(i));
            if (gasAvailable < 0) {
                gasShortage += (Math.abs(gasAvailable));
                startPoint = i + 1;
                gasAvailable = 0;
            }
        }
        return gasShortage < gasAvailable ? startPoint : -1;
    }

    private int maxRectangleArea(int[][] matrix) {
        Integer[] result = new Integer[matrix[0].length];
        int maxValue = 0;
        Arrays.fill(result, 0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j] += matrix[i][j];
                if (matrix[i][j] == 0)
                    result[j] = 0;
            }
            maxValue = Math.max(maxValue, getMaxArea(result));
        }
        return maxValue;
    }

    private int getMaxArea(Integer[] input) {
        List<Integer> sortedUniqueValueList = Arrays.stream(input).filter((x) -> x != 0).distinct()
                .sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int sum = 0;
        int maxValue = 0;
        for (Integer uniqueValue : sortedUniqueValueList) {
            sum = 0;
            int maxArea = 0;
            for (int i = 0; i < input.length; i++) {
                sum += uniqueValue;
                if (input[i] < uniqueValue) {
                    sum = 0;
                }
                maxArea = Math.max(maxArea, sum);
            }
            maxValue = Math.max(maxValue, maxArea);
        }
        return maxValue;
    }
}
package maths;
import java.util.*;

public class ThreeNumberSum {

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(12, 3, 1, 2, -6, 5, -8, 6);
        int targetSum = 0;

        int[] input = inputList.stream().mapToInt(i -> i).toArray();

        List<Integer[]> result = threeNumberSum(input, targetSum);
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        Arrays.sort(array);
        Set<List<Integer>> result = new HashSet<List<Integer>>();

        for (int i = 0; i < array.length; i++) {
            int targetSum2 = targetSum-array[i];
            Integer[] twoSum = twoNumberSum(array, targetSum2, i);
            if (twoSum != null) {
                Integer[] threeSum = new Integer[3];
                threeSum[0] = array[i];
                threeSum[1] = twoSum[0];
                threeSum[2] = twoSum[1];
                Arrays.sort(threeSum);
                result.add((List<Integer>) Arrays.asList(threeSum));
            }
        }

        return toList(result);
    }

    private static List<Integer[]> toList(Set<List<Integer>> input) {
        List<Integer[]> result = new ArrayList<Integer[]>();
        for (List<Integer> triplet : input) {
            result.add(getIntArray(triplet));
        }
        Collections.sort(result, new Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b) {
                for (int i = 0; i < a.length; i++) {
                    if (a[i] != b[i]) {
                        return a[i].compareTo(b[i]);
                    }
                }
                
                return 0;
            }
        });
        return result;
    }

    private static Integer[] getIntArray(List<Integer> input) {
        Integer[] result = new Integer[input.size()];
        for (int i = 0; i < input.size(); i++) {
            result[i] = input.get(i);
        }
        return result;
    }

    private static Integer[] twoNumberSum(int[] array, int targetSum, int indexToIgnore) {
        HashSet<Integer> visited = new HashSet<>();

        for (int j = 0; j < array.length; j++) {
            if (j == indexToIgnore) {
                continue;
            }
            if (visited.contains(targetSum-array[j])) {
                Integer[] result = new Integer[2];
                result[0] = array[j];
                result[1] = targetSum-array[j];
                return result;
            }
            visited.add(array[j]);
        }
        return null;
    }
}

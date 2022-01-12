package maths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class FindRectangles {

    public static void main(String[] args) {
        List<Pair> coordinates = test3();

        System.out.println("Number of rectangles: " + findNumberOfRectangles(coordinates));
    }

    private static List<Pair> test1() {
        List<Pair> coordinates = new ArrayList<>();
        coordinates.add(new Pair(1, 1));
        coordinates.add(new Pair(1, 2));
        coordinates.add(new Pair(2, 1));
        coordinates.add(new Pair(2, 2));
        coordinates.add(new Pair(3, 1));
        //coordinates.add(new Pair(3, 2));
        coordinates.add(new Pair(4, 1));
        coordinates.add(new Pair(4, 2));

        return coordinates;
    }

    private static List<Pair> test2() {
        List<Pair> coordinates = new ArrayList<>();
        coordinates.add(new Pair(1, 1));
        coordinates.add(new Pair(1, 2));
        coordinates.add(new Pair(1, 3));
        coordinates.add(new Pair(2, 1));
        coordinates.add(new Pair(2, 3));
        coordinates.add(new Pair(3, 1));
        coordinates.add(new Pair(3, 2));
    
        return coordinates;
    }

    private static List<Pair> test3() {
        List<Pair> coordinates = new ArrayList<>();
        coordinates.add(new Pair(1, 1));
        coordinates.add(new Pair(1, 3));
        coordinates.add(new Pair(2, 1));
        coordinates.add(new Pair(2, 2));
        coordinates.add(new Pair(3, 1));
    
        return coordinates;
    }

    private static List<Pair> test4() {
        List<Pair> coordinates = new ArrayList<>();
        coordinates.add(new Pair(1, 2));
        coordinates.add(new Pair(1, 3));
        coordinates.add(new Pair(2, 1));
        coordinates.add(new Pair(2, 2));
        coordinates.add(new Pair(3, 1));
    
        return coordinates;
    }

    public static Integer findNumberOfRectangles(final List<Pair> coordinates) {
        if (coordinates == null || coordinates.size() == 0) {
            return 0;
        }
        
        // Traverse all the coordinates and create y coordinate Map
        Map<Integer, List<Integer>> rawYToXMap = createYMap(coordinates);

        // Filter out any y coordinate where there is only 1 x
        Map<Integer, List<Integer>> yToXMap = rawYToXMap.entrySet().stream()
        .filter(entry -> (entry.getValue().size() >= 2)).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        // Match the number of x coordinates between lists
        List<List<Integer>> xMapList = yToXMap.values().stream().collect(Collectors.toList());

        int sum = 0;

        // Find the intersection between two x sets and NC2 on that
        for (int i = 0; i < xMapList.size(); i++) {
            for (int j = i+1; j < xMapList.size(); j++) {
                final List<Integer> jMap = xMapList.get(j);
                List<Integer> matched = xMapList.get(i).stream().filter(c -> jMap.contains(c)).collect(Collectors.toList());
                if (matched.size() > 1) {
                    sum += nC2(matched.size());
                }
                
            }
        }

        return sum;
    }

    private static int nC2(int n) {
        // base case
        if (n == 0 || n == 1) return 1;
     
        // recursion
        return factorial(n)/(factorial(n-2) * factorial(2));
    }

    private static int factorial(int n) {
        // base case
        if (n == 0) return 1;
     
        // recursion
        return n * factorial(n-1);
    }

    private static HashMap<Integer, List<Integer>> createYMap(final List<Pair> coordinates) {
        HashMap<Integer, List<Integer>> yToXMap = new HashMap<>();
        for (Pair c : coordinates) {
            List<Integer> xList;
            if(yToXMap.containsKey(c.y)) {
                xList = yToXMap.get(c.y);
            } else {
                xList = new ArrayList<>();
            }
            xList.add(c.x);
            yToXMap.put(c.y, xList);
        }
        return yToXMap;
    }
}

class Pair {
    public Integer x;
    public Integer y;

    public Pair(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
package array;

import java.util.*;

public class ApartmentHunting {

    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        Map<String, Boolean> block1 = new HashMap<>();
        block1.put("gym", false);
        block1.put("school", true);
        block1.put("store", false);
        blocks.add(block1);

        Map<String, Boolean> block2 = new HashMap<>();
        block2.put("gym", true);
        block2.put("school", false);
        block2.put("store", false);
        blocks.add(block2);

        Map<String, Boolean> block3 = new HashMap<>();
        block3.put("gym", true);
        block3.put("school", true);
        block3.put("store", false);
        blocks.add(block3);

        Map<String, Boolean> block4 = new HashMap<>();
        block4.put("gym", false);
        block4.put("school", true);
        block4.put("store", false);
        blocks.add(block4);

        Map<String, Boolean> block5 = new HashMap<>();
        block5.put("gym", false);
        block5.put("school", true);
        block5.put("store", true);
        blocks.add(block5);

        String[] reqs = new String[]{"gym", "school", "store"};
        int result = apartmentHunting(blocks, reqs);
        System.out.println(result);
    }

    // Time: O(3*br), Space: O(br) + O(r)
    // The main highlights of this are
    // 1. Taking a forward pass and then a backward pass to record distances
    // 2. Find the min number of steps to walk at any time to derive optimal block
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        if (blocks == null || blocks.size() == 0) {
            return -1;
        }

        if (reqs == null || reqs.length == 0) {
            return 0;
        }

        List<Map<String, Integer>> distanceMapOfBlocks = new ArrayList<>();
        Map<String, Integer> lastIndexMap = new HashMap<>();
        int maxDistance = blocks.size();

        // Forward pass
        for (int i = 0; i < blocks.size(); i++) {
            Map<String, Integer> distanceMap = new HashMap<>();
            for (String req : reqs) {
                // Req is met at this block itself
                int lastFound = Integer.MAX_VALUE;
                if (blocks.get(i).get(req)) {
                    lastFound = i;
                } else if (lastIndexMap.containsKey(req)) {
                    // Req is met from last identified
                    lastFound = lastIndexMap.get(req);
                }
                distanceMap.put(req, Math.abs(i-lastFound));
                if (lastFound < maxDistance) {
                    // Update the last found index
                    lastIndexMap.put(req, lastFound);
                }
            }
            distanceMapOfBlocks.add(distanceMap);
        }

        // Backward pass
        lastIndexMap = new HashMap<>();
        for (int i = blocks.size()-1; i >= 0; i--) {
            for (String req : reqs) {
                int lastFound = Integer.MAX_VALUE;
                if (blocks.get(i).get(req)) {
                    lastFound = i;
                } else if (lastIndexMap.containsKey(req)) {
                    // Req is met from last identified
                    lastFound = lastIndexMap.get(req);
                }
                int previousDistance = distanceMapOfBlocks.get(i).get(req);
                distanceMapOfBlocks.get(i).put(req, Math.min(previousDistance, Math.abs(lastFound-i)));
                if (lastFound < maxDistance) {
                    // Update the last found index
                    lastIndexMap.put(req, lastFound);
                }
            }
        }

        return findBestApartment(distanceMapOfBlocks, reqs);
    }

    private static int findBestApartment(List<Map<String, Integer>> blocks, String[] reqs) {
        int minWalk = Integer.MAX_VALUE;
        int bestApartment = -1;
        for (int i = 0; i < blocks.size(); i++) {
            int maxWalk = Integer.MIN_VALUE;
            for (String req : reqs) {
                if (blocks.get(i).containsKey(req)) {
                    maxWalk = Math.max(maxWalk, blocks.get(i).get(req));
                }
            }
            if (maxWalk < minWalk) {
                minWalk = maxWalk;
                bestApartment = i;
            }
        }
        return bestApartment;
    }
    
}

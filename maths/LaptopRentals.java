package maths;

import java.util.*;

public class LaptopRentals {

    public static void main(String[] args) {
        LaptopRentals obj = new LaptopRentals();

        ArrayList<ArrayList<Integer>> times = new ArrayList<>();
        times.add(new ArrayList<Integer>(Arrays.asList(0,2)));
        times.add(new ArrayList<Integer>(Arrays.asList(1,4)));
        times.add(new ArrayList<Integer>(Arrays.asList(4,6)));
        times.add(new ArrayList<Integer>(Arrays.asList(0,4)));
        times.add(new ArrayList<Integer>(Arrays.asList(7,8)));
        times.add(new ArrayList<Integer>(Arrays.asList(9,11)));
        times.add(new ArrayList<Integer>(Arrays.asList(3,10)));

        int count = obj.laptopRentals(times);
        System.out.println(count);
    }

    // Check other implementations of this code
    // Time: O(nlogn), Space: O(1)
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {

        sort(times);
        int maxTime = maxTime(times);
        int count = count(times, maxTime);

        return count;
    }

    private ArrayList<ArrayList<Integer>> sort(ArrayList<ArrayList<Integer>> times) {
        
        Collections.sort(times, new Comparator<ArrayList<Integer>>(){
            
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                Integer start1 = o1.get(0);
                Integer start2 = o2.get(0);

                return start1.compareTo(start2);
            }
        });

        return times;
    }

    private int maxTime(ArrayList<ArrayList<Integer>> times) {
        int maxTime = Integer.MIN_VALUE;
        for (ArrayList<Integer> slot: times) {
            if (slot.get(1) > maxTime) {
                maxTime = slot.get(1);
            }
        }
        return maxTime;
    }

    private int count(ArrayList<ArrayList<Integer>> times, int maxTime) {
        int count = 0;
        for (int i = 0; i <= maxTime; i++) {
            for (ArrayList<Integer> slot: times) {
                int slotStart = slot.get(0);
                int slotEnd = slot.get(1);

                if (slotStart > i) {
                    break;
                }

                if (i == slotEnd) {
                    count++;
                }

                if (i == slotStart) {
                    if (count == 0) {
                        count++;
                    }
                    count--;
                }

                
            }
        }
        return count;
    }

    private void print(ArrayList<ArrayList<Integer>> times) {
        for (ArrayList<Integer> slot: times) {
            System.out.println(slot.get(0) + " " + slot.get(1));
        }
    }
    
}

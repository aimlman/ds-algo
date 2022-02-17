package maths;

import java.util.*;

public class TaskAssignment {

    public static void main(String[] args) {
        int k = 3;
        ArrayList<Integer> tasks = new ArrayList<Integer>(Arrays.asList(1,3,5,3,1,4));
        TaskAssignment obj = new TaskAssignment();
        ArrayList<ArrayList<Integer>> result = obj.taskAssignment(k, tasks);
        for (ArrayList<Integer> pair: result) {
            System.out.println(pair.get(0) + " " + pair.get(1));
        }
    }

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {

        ArrayList<Pair> pairList = new ArrayList<>(tasks.size());
        for (int i = 0; i < tasks.size(); i++) {
            pairList.add(new Pair(tasks.get(i), i));
        }

        Collections.sort(pairList, new Comparator<Pair>() {
            @Override
            public int compare(final Pair o1, final Pair o2){
                return o1.value.compareTo(o2.value);
            }
        });

        int start = 0;
        int end = pairList.size()-1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(k); 
        while (start < end) {
            ArrayList<Integer> pair = new ArrayList<>(2);
            pair.add(pairList.get(start).index);
            pair.add(pairList.get(end).index);
            result.add(pair);
            start++;
            end--;
        }

        return result;
    }

    static class Pair{
        Integer value;
        Integer index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
}

package sort;

import java.util.*;

public class RenderACalendar {

    public static void main(String[] args) {
        ArrayList<Event> input = new ArrayList<>();
        input.add(new Event(1,5));
        input.add(new Event(4,5));
        input.add(new Event(2,7));
        input.add(new Event(8,9));
        input.add(new Event(6,10));
        input.add(new Event(11,13));
        input.add(new Event(14,15));
        input.add(new Event(12,15));
        input.add(new Event(9,17));

        int result = new RenderACalendar().findMaxSimultaneousEvents(input);
        System.out.println(result);

    }


    public int findMaxSimultaneousEvents(ArrayList<Event> events) {
        int maxCount = 0;
        Node[] nodes = new Node[events.size()*2];
        int index = 0;

        for (Event event: events) {
            nodes[index++] = new Node(event.start, true);
            nodes[index++] = new Node(event.end, false);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if (a.time == b.time) {
                    if (a.start) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (a.time > b.time) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (Node n: nodes) {
            System.out.println(n);
        }

        int count = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].start == true) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count--;
            }
            
        }

        return maxCount;
    }

    static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Node {
        int time;
        boolean start;

        public Node(int time, boolean start) {
            this.time = time;
            this.start = start;
        }

        public String toString() {
            return  String.valueOf(time) + " " + String.valueOf(start);
        }
    }
    
}

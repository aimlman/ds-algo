package linkedlist;

public class RemoveDuplicates {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next.next.next = new LinkedList(6);
        head.next.next.next.next.next.next.next.next = new LinkedList(6);

        RemoveDuplicates obj = new RemoveDuplicates();
        head = obj.removeDuplicatesFromLinkedList(head);

        LinkedList current = head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }

    }

    // Time: O(n), Space: O(1)
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList current = linkedList;
        LinkedList next = linkedList;
        int currentValue = linkedList.value;
        while(current != null) {
            while (next != null && next.value == currentValue) {
                next = next.next;
            }
            current.next = next;
            current = next;
            if (next != null) currentValue = next.value;
        }
        return linkedList;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
        }
    }
    
}

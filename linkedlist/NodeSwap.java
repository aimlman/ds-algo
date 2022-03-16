package linkedlist;

public class NodeSwap {

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);
        // head.next.next.next.next.next = new LinkedList(6);

        NodeSwap obj = new NodeSwap();
        head = obj.nodeSwap(head);
        System.out.println(head.value);
    }

    // Time: O(n), Space: O(1)
    public LinkedList nodeSwap(LinkedList head) {
        LinkedList currentNode = head;
        while(currentNode != null && currentNode.next != null) {
            swap(currentNode, currentNode.next);
            currentNode = currentNode.next.next;
        }

        return head;
    }

    private void swap(LinkedList first, LinkedList second) {
        if (first != null && second != null) {
            int temp = first.value;
            first.value = second.value;
            second.value = temp;
        }
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

    }
    
}

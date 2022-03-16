package linkedlist;

public class ZipLinkedList {
    
    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next = new LinkedList(6);

        ZipLinkedList obj = new ZipLinkedList();
        head = obj.zipLinkedList(head);
        System.out.println(head.value);
    }

    // Time: O(n/2 + n/2 + n), Space: O(1)
    public LinkedList zipLinkedList(LinkedList linkedList) {
        // Find the middle node
        LinkedList middleNode = findMiddleNode(linkedList);

        // Reverse the second half
        LinkedList reverseHead = reverseLinkedList(middleNode);

        // Zip the forward linked list with reverse linked list
        zipLinkedList(linkedList, reverseHead);

        return linkedList;
    }

    private LinkedList findMiddleNode(LinkedList head) {
        LinkedList slowPointer = head;
        LinkedList fastPointer = head;
        while(fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    private LinkedList reverseLinkedList(LinkedList head) {
        LinkedList currentNode = head;
        LinkedList lastNode = null;
        while(currentNode != null) {
            LinkedList nextNode = currentNode.next;
            currentNode.next = lastNode;
            lastNode = currentNode;
            currentNode = nextNode;
        }
        return lastNode;
    }

    private void zipLinkedList(LinkedList head, LinkedList reverseHead) {
        while(reverseHead.next != null) {
            LinkedList previousNext = head.next;
            head.next = reverseHead;
            reverseHead = reverseHead.next;
            head.next.next = previousNext;
            head = previousNext;
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

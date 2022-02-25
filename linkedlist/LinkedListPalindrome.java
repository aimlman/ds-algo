package linkedlist;

public class LinkedListPalindrome {

    public static void main(String[] args) {
        LinkedListPalindrome obj = new LinkedListPalindrome();

        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(0);

        boolean isPalindrome = obj.linkedListPalindrome(head);
        System.out.println(isPalindrome);
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Time: O(N), Space: O(1)
    public boolean linkedListPalindrome(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        
        LinkedList firstHalf = head;
        LinkedList secondHalf = reverse(slow);
        while(secondHalf != null) {
            if(firstHalf.value != secondHalf.value) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private LinkedList reverse(LinkedList head) {
        LinkedList previousNode = null;
        LinkedList currentNode = head;
        while(currentNode != null) {
            LinkedList nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    // Time: O(N), Space: O(1)
    public boolean linkedListPalindrome_recursive(LinkedList head) {
        LinkedList node = compareNodes(head, head);
        return node == null ? false : true;
    }

    public LinkedList compareNodes(LinkedList head, LinkedList node) {
        LinkedList last = node;
        if (last == null) {
            return head;
        }
        LinkedList first = compareNodes(head, last.next);
        if (first != null && first.value == last.value) {
            return first.next == null ? head : first.next;
        } else {
            return null;
        }

    }
    
}

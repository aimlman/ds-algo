package linkedlist;

import java.util.*;

public class SumOfLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;
    
        public LinkedList(int value) {
          this.value = value;
          this.next = null;
        }
    }

    public static void main(String[] args) {
        SumOfLinkedList obj = new SumOfLinkedList();
        LinkedList ll1 = obj.addMany(new LinkedList(2), new int[] {4, 7, 1});
        LinkedList ll2 = obj.addMany(new LinkedList(9), new int[] {4, 5});
        LinkedList sum = obj.sumOfLinkedLists(ll1, ll2);
        while(sum != null) {
            System.out.println(sum.value);
            sum = sum.next;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        if (linkedListOne == null && linkedListTwo == null) {
            return null;
        }
        if (linkedListOne == null) {
            return linkedListTwo;
        }
        if (linkedListTwo == null) {
            return linkedListOne;
        }
        
        boolean ll1TraversalComplete = false;
        boolean ll2TraversalComplete = false;
        LinkedList ll1 = linkedListOne;
        LinkedList ll2 = linkedListTwo;

        LinkedList result = null;
        LinkedList currentNode = result;
        int overflow = 0;
        while(!(ll1TraversalComplete && ll2TraversalComplete) && overflow > 0) {
            // Sum the digits
            int sum = ((ll1TraversalComplete) ? 0 : ll1.value) + ((ll2TraversalComplete) ? 0 : ll2.value) + overflow;
            if (currentNode == null) {
                result = new LinkedList(sum % 10);
                currentNode = result;
            } else {
                currentNode.next = new LinkedList(sum % 10);
                currentNode = currentNode.next;
            }
            overflow = sum/10;

            if (ll1.next == null) {
                ll1TraversalComplete = true;
            } else {
                ll1 = ll1.next;
            }
            if (ll2.next == null) {
                ll2TraversalComplete = true;
            }  else {
                ll2 = ll2.next;
            }
        }
        return result;
    }

    public LinkedList addMany(LinkedList linkedList, int[] values) {
        var current = linkedList;
        while (current.next != null) {
          current = current.next;
        }
        for (var value : values) {
          current.next = new LinkedList(value);
          current = current.next;
        }
        return linkedList;
      }
    
    public ArrayList<Integer> getNodesInArray(LinkedList linkedList) {
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        LinkedList current = linkedList;
        while (current != null) {
            nodeValues.add(current.value);
            current = current.next;
        }
        return nodeValues;
    }
    
}

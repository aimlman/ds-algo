package stack;

import java.util.*;

public class MinMaxStackProgram {

    public static void main(String[] args) {
        MinMaxStack stack = new MinMaxStack();
        System.out.println(stack.peek() + " " + stack.getMax() + " " + stack.getMin());
        stack.push(5);
        System.out.println(stack.peek() + " " + stack.getMax() + " " + stack.getMin());
        stack.push(7);
        System.out.println(stack.peek() + " " + stack.getMax() + " " + stack.getMin());
        stack.push(2);
        System.out.println(stack.peek() + " " + stack.getMax() + " " + stack.getMin());
        stack.pop();
        System.out.println(stack.peek() + " " + stack.getMax() + " " + stack.getMin());
        stack.pop();
        System.out.println(stack.peek() + " " + stack.getMax() + " " + stack.getMin());
    }

    static class MinMaxStack {
        ArrayList<Node> stack = new ArrayList<>();

        public int peek() {
            if (this.stack.size() > 0) {
                return this.stack.get(this.stack.size()-1).value;
            }
            return -1;
        }
    
        public int pop() {
            if (this.stack.size() > 0) {
                Node last = this.stack.get(this.stack.size()-1);
                this.stack.remove(this.stack.size()-1);
                return last.value;
            }
            return -1;
        }
    
        public void push(Integer number) {
            int max = number;
            int min = number;
            if (this.stack.size() > 0) {
                Node last = this.stack.get(this.stack.size()-1);
                max = last.maxValue > number ? last.maxValue : number;
                min = last.minValue < number ? last.minValue : number;

            }
            this.stack.add(new Node(number, max, min));
        }
    
        public int getMin() {
            if (this.stack.size() > 0) {
                return this.stack.get(this.stack.size()-1).minValue;
            }
            return -1;
        }
    
        public int getMax() {
            if (this.stack.size() > 0) {
                return this.stack.get(this.stack.size()-1).maxValue;
            }
            return -1;
        }

        class Node {
            Integer value;
            Integer minValue;
            Integer maxValue;

            public Node(int value, int max, int min) {
                this.value = value;
                this.maxValue = max;
                this.minValue = min;
            }
        }
    }
    
}

package graph;

import java.util.*;

public class BreadthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();
    
        public Node(String name) {
          this.name = name;
        }
    
        public List<String> breadthFirstSearch(List<String> array) {

            ArrayList<Node> queue = new ArrayList<>();
            queue.add(this);

            while (queue.size() > 0) {
                Node node = queue.remove(0);
                array.add(node.name);
                queue.addAll(node.children);
            }
            
          // Write your code here.
          return array;
        }
    
        public Node addChild(String name) {
          Node child = new Node(name);
          children.add(child);
          return this;
        }
    }
    
}

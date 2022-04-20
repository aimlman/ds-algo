package graph;

import java.util.*;

public class DepthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();
    
        public Node(String name) {
          this.name = name;
        }
    
        public List<String> depthFirstSearch(List<String> array) {
          
          array.add(this.name);

          if (this.children == null) {
              return array;
          }

          for(Node child: children) {
              child.depthFirstSearch(array);
          }
          return array;
        }
    
        public Node addChild(String name) {
          Node child = new Node(name);
          children.add(child);
          return this;
        }
    }
    
}

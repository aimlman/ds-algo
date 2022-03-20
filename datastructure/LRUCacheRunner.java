package datastructure;

import java.util.*;

public class LRUCacheRunner {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.insertKeyValuePair("b", 2);
        cache.insertKeyValuePair("a", 1);
        cache.insertKeyValuePair("c", 3);
        System.out.println(cache.getMostRecentKey());
        System.out.println(cache.getValueFromKey("a").value);
        System.out.println(cache.getMostRecentKey());
        cache.insertKeyValuePair("d", 4);
        System.out.println(cache.getValueFromKey("b").value);
        cache.insertKeyValuePair("a", 5);
        System.out.println(cache.getValueFromKey("a").value);
    }
    

    static class LRUCache {
        
        int maxSize;
        Map<String, DLLNode> cache = new HashMap<>(maxSize); 
        DLL mru = new DLL();
        int size = 0;
    
        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        public void insertKeyValuePair(String key, int value){

            if (!cache.containsKey(key)) {
                // Cache doesn't contain key
                if (size == maxSize) {
                    // Evict cache
                    evictLeastRecent();
                } else {
                    // Add to cache
                    size++;
                }
                cache.put(key, new DLLNode(key, value));
            } else {
                // Cache contains key
                // Replace cache
                replaceKey(key, value);
            }

            // Update most recent use
            updateMostRecent(cache.get(key));
        }

        private void evictLeastRecent() {
            String key = mru.tail.key;
            cache.remove(key);
            mru.removeTail();
        }

        private void replaceKey(String key, Integer value) {
            if (!cache.containsKey(key)) {
                return;
            }
            cache.get(key).value = value;
        }

        private void updateMostRecent(DLLNode node) {
            mru.updateHead(node);
        }
    
        public LRUResult getValueFromKey(String key) {
            if (!cache.containsKey(key)) {
                return new LRUResult(false, -1);
            }
            updateMostRecent(cache.get(key));
            return new LRUResult(true, cache.get(key).value);
            
        }
    
        public String getMostRecentKey() {
            if (mru.head == null) {
                return "";
            }
            return mru.head.key;
        }
    }

    static class DLL {
        public DLLNode head;
        public DLLNode tail;

        public void updateHead(DLLNode node) {
            if (head == node) {
                return;
            } else if (head == null) {
                head = node;
                tail = node;
            } else if (head == tail) {
                tail.previous = node;
                head = node;
                head.next = tail;
            } else {
                if (tail == node) {
                    removeTail();
                }
                node.removeNode();
                head.previous = node;
                node.next = head;
                head = node;
            }
           
        }

        public void removeTail() {
            if (tail == null) {
                return;
            }
            if (tail == head) {
                head = null;
                tail = null;
                return;
            }
            tail = tail.previous;
            tail.next = null;
        }
    }

    static class DLLNode {
        public String key;
        public Integer value;
        public DLLNode previous;
        public DLLNode next;

        public DLLNode(String key, Integer value) {
            this.key = key;
            this.value = value;
            this.previous = null;
            this.next = null;
        }

        public void removeNode() {
            if (previous != null) {
                previous.next = next;
            }
            if (next != null) {
                next.previous = previous;
            }
            previous = null;
            next = null;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }
    
}

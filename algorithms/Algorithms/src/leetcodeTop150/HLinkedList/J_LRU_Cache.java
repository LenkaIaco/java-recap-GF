package leetcodeTop150.HLinkedList;

import java.util.HashMap;
import java.util.Map;

public class J_LRU_Cache {
    /*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:
//LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//int get(int key) Return the value of the key if the key exists, otherwise return -1.
//void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
If the number of keys exceeds the capacity from this operation, evict the least recently used key.
//The functions get and put must each run in O(1) average time complexity.

    ---------------
    The Core Approach: Combining a Hash Map and a Doubly Linked List
The goal is to design a cache with a fixed capacity that evicts the least recently used item when it's full. To be considered optimal, the get and put operations must have a time complexity of O(1).

No single standard data structure can achieve this on its own:

A Hash Map (dict, unordered_map, etc.) provides O(1) average time for lookups, insertions, and deletions, but it doesn't maintain the order of use.
A Linked List or Array maintains order, but finding an item takes O(n) time.
The optimal solution is to combine the strengths of both:

A Hash Map: The map will store the keys of the cache. The value associated with each key will be a pointer or reference to a node in a doubly linked list. This gives us O(1) access to any cache item.
A Doubly Linked List: This list will store the actual key-value pairs in its nodes. The order of the list represents the recency of use. We'll maintain a convention:
The head/front of the list is the Most Recently Used (MRU) item.
The tail/back of the list is the Least Recently Used (LRU) item.
How Operations Work in O(1) Time:

get(key): We use the hash map to instantly find the corresponding node in the linked list. We then move this node to the head of the list (marking it as MRU) and return its value. Moving a node in a doubly linked list is an O(1) operation.
put(key, value):
If the key already exists, we use the map to find its node, update the value, and move the node to the head of the list.
If the key is new, we create a new node and add it to the head of the list. We then add the key and a reference to this new node to the map.
After adding, if the cache size exceeds its capacity, we remove the node from the tail of the list (the LRU item) and also remove its key from the hash map.

 NOTE: The example's 'least recently' logic is counterintuitive and thus does not match my below implementation
    Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3} // this is counterintuitive, as least recently used is 1, not 2
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

     */
    class DoublyLinkedNode {
        public int value;
        public DoublyLinkedNode prev;
        public DoublyLinkedNode next;
    }

    int capacity;
    int value;
    Map<Integer, DoublyLinkedNode> pairs;
    DoublyLinkedNode head;
    DoublyLinkedNode tail;

    public J_LRU_Cache(int capacity) {
        pairs = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (pairs.containsKey(key)) {
            DoublyLinkedNode current = pairs.get(key);
            this.makeHead(current);
            return current.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DoublyLinkedNode newDLN = new DoublyLinkedNode();
        newDLN.value = value;

        if (pairs.containsKey(key)) {
            pairs.get(key).value = value;
            newDLN = pairs.get(key);
        } else {pairs.put(key, newDLN);}
        this.makeHead(newDLN);

        if (pairs.size()>capacity){
            DoublyLinkedNode beforeTail = tail.prev;
            tail = beforeTail;
           if (beforeTail!=null) {
               beforeTail.next = null;
           }
        }
    }

        public void makeHead(DoublyLinkedNode current){
            if (head==null || current != head) {
                if (tail!=null && current==tail){
                    tail =  tail.prev;
                }
                if (current.prev!=null) {
                    current.prev.next = current.next;
                }
                if (head!=null) {
                    head.prev = current;
                    current.next = head;
                }
                head = current;
                if (tail==null){
                    tail = current;
                }
            }
        }

}

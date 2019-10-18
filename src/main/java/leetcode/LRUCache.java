package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Alex.Z
 * @DATE: 2018/9/20
 * @Description:
 *
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 （  capacity ） );
 *
 *         cache.put(1, 1);
 *         cache.put(2, 2);
 *         cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 *
 *
 * 解题思路：利用hashMap和linkedList来完成这个任务，linkedList可以快速的增删，hashMap可以快速的定位
 */





public class LRUCache {

    protected class Node{
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        public Node next;
        public Node prev;
        public int val;
        public int key;
    }


    private int capacity;
    private int size;
    private Node head;//带头节点的链表
    private Node tail;//带尾节点
    private Map<Integer, Node> locateMap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        locateMap = new HashMap<>(capacity * 2);
    }

    public int get(int key) {
        Node tmp = locateMap.get(key);
        if(null!=tmp) {
            removeNode(tmp);
            putFirst(tmp);
            return tmp.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node newNode =new Node(key, value);
        Node ifExists = locateMap.get(key);
        if(null!= ifExists) {
            removeNode(ifExists);
            size-=1;
        }
        locateMap.put(key, newNode);
        if(size==capacity) {
            //evicts from head
            removeLast();
            size-=1;
        }
        putFirst(newNode);
        size+=1;
    }

    private void putFirst(Node tmp) {
        tmp.next = head.next;
        tmp.next.prev = tmp;
        tmp.prev = head;
        head.next = tmp;
    }

    private void removeNode(Node tmp) {
        tmp.next.prev = tmp.prev;
        tmp.prev.next = tmp.next;
    }

    private void removeLast() {
        if(tail.prev == head) return;
        else{
            locateMap.remove(tail.prev.key);
            removeNode(tail.prev);

        }
    }
}

package Hashing;

import java.util.ArrayList;
import java.util.List;

public class MyMap {

    public static void main(String[] args) {

    }

}


class CustomMap<K, V> {
    private List<Node<K, V>> bucketArray;
    private int capacity; // Length of the bucket or list size
    private int size; // number of elements in the map or hashMap size
    private final int INITIAL_CAPACITY = 5; // initial length of the bucket array

    public CustomMap() {
        bucketArray = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        for (int i = 0; i < capacity; i++) {
            bucketArray.add(i, null);
        }
    }

    public V get(K key) {
        /// Find the key where the key may potentially reside
        int bucketIndex = getBucketIndex(key);
        Node<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            /// We dont use the == because it compares the memory address whereas .equals
            /// uses the equals and hashCode method by overriding it
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    /// Hash Function
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        /// Compression function to compress the index within the bounds of the array
        return hashCode % capacity;
    }


    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> head = bucketArray.get(bucketIndex);
        /// When the searched element is found
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        /// When the searched element is not found
        size++;
        Node<K, V> entry = new Node<>(key, value);
        head = bucketArray.get(bucketIndex);
        entry.next = head;
        bucketArray.set(bucketIndex, entry);
        if (loadFactor() > 0.7) rehash();
    }

    /// n/b ratio
    private void rehash() {
        List<Node<K, V>> temp = bucketArray;
        bucketArray = new ArrayList<>();
        capacity = 2 * capacity;
        size = 0;

        for (int i = 0; i < capacity; i++) bucketArray.add(i, null);

        for (Node<K, V> headNode : temp) {
            while (headNode != null) {
                put(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> head = bucketArray.get(bucketIndex);
        Node<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    bucketArray.set(bucketIndex, head.next);
                } else {
                    prev.next = head.next;
                }
                head.next = null;
                size--;
                break;
            }
            prev = head;
            head = head.next;
        }
    }

    private double loadFactor() {
        return (1.0 * size) / capacity;
    }


    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }


    }

}

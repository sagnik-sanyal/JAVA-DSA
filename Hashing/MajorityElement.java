package Hashing;

import java.util.HashMap;

public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        majorityElement(arr);
    }

    /// Given an integer array of size n, find all the elements that appear more than n/3 times
    private static void majorityElement(int[] arr) {
        // Create the hashMap
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // Fill the elements in the hashMap
        for (int i : arr) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }

        // Filter out the elements where the frequenecy is greater than n / 3;
        final int freq = arr.length / 3;
        for (int key : hashMap.keySet()) {
            // Print the elements
            if (hashMap.get(key) > freq) System.out.print(key + " ");
        }
    }

}

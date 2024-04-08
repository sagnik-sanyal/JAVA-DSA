package Hashing;

import java.util.HashSet;

public class ArrayIntersection {

    public static void main(String[] args) {
        int[] arr1 = new int[]{7, 3, 9};
        int[] arr2 = new int[]{6, 3, 9, 2, 9, 4};
        System.out.println("\nNumber of intersections: " + arrayIntersection(arr1, arr2));
    }

    /// Create a hashset and add elements from one array into it
    /// run a loop into the other array and check whether the item already exist
    private static int arrayIntersection(int[] arr1, int[] arr2) {
        // Create the hashSet and add elements to it
        final HashSet<Integer> hashSet = new HashSet<>();
        for (int i : arr1) hashSet.add(i);

        // Create a count variable to match the intersection of the element
        int intersectCount = 0;

        // Iterate over the other array and check whether it contains the item or not
        for (int j : arr2) {
            if (!hashSet.contains(j)) continue;
            intersectCount++;
            System.out.print(j + " ");
            hashSet.remove(j);
        }

        return intersectCount;
    }


}

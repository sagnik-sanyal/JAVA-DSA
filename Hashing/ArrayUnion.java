package Hashing;

import java.util.HashSet;

public class ArrayUnion {

    /// O(n)
    public static void main(String[] args) {
        int[] arr1 = new int[]{7, 3, 9};
        int[] arr2 = new int[]{6, 3, 9, 2, 9, 4};
        System.out.print(arrayUnion(arr1, arr2));
    }

    /// Set size
    private static int arrayUnion(int[] arr1, int[] arr2) {
        final HashSet<Integer> arraySet = new HashSet<>();
        for (int i : arr1) arraySet.add(i);
        for (int j : arr2) arraySet.add(j);
        return arraySet.size();
    }

}

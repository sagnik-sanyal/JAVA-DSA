import java.util.LinkedHashSet;

public class ArrayImpl {

    public static void main(String[] args) {
        // Use this function to utilise this
    }

    public static int[] removeDuplicates(int[] arr) {
        final LinkedHashSet<Integer> set = new LinkedHashSet<>(arr.length);
        for (int i : arr) {
            set.add(i);
        }
        int j = 0;
        for (int x : set) {
            arr[j++] = x;
        }
        return arr;
    }

    // Question iD
    // https://takeuforward.org/data-structure/find-the-largest-element-in-an-array/
    public static int largestElement(int[] array) {
        int largestElement = 0;
        for (int i : array) {
            if (i > largestElement) largestElement = i;
        }
        return largestElement;
    }

    // Question Id
    // https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/
    public static int[] secondLargestNumber(int n, int[] a) {
        int secondLargestNum = 0;
        int secondSmallestNum = 0;
        int largestNum = 0;
        int smallestNum = 0;
//        for (int i : a) {
        // Sort the array and return the results
        // or iterate over the array twice to find the largest elements and in the second iteration find the second largest one
        // or use the method i used just now

//        }
        return new int[]{secondLargestNum, secondSmallestNum};
    }

}

public class RatFood {

    public static void main(String[] args) {
        // Declare food array
        int[] foodArray = new int[]{2,8,3,5,7,4,1,2};
        int ratFood = computeRatFood(7,2,foodArray,8);
        System.out.println(ratFood);
    }

    public static int computeRatFood(int r, int unit, int[] arr, int n){
        if (arr == null) return -1;
        int requiredFood = r * unit;
        int foodFromHouse = 0;
        // Index issue bug
        for (int i = 0; i < n; i++) {
            if (foodFromHouse >= requiredFood) return i;
            foodFromHouse += arr[i];
        }
        return 0;
    }

}


public class CheckPassword {

    public static void main(String[] args) {
        System.out.println(checkPassword("aA1_67",6));
    }

    public static int checkPassword(String str, int n) {
        if (n < 4) return 0;
        if (isNumberIndexed(str,0)) return 0;
        int nums = 0, caps = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '/' || str.charAt(i) == ' ') return 0;
            if (isNumberIndexed(str,i)) {
                nums++;
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                caps++;
            }
        }
        return (nums != 0 && caps != 0) ? 1 : 0;
    }

    public static boolean isNumberIndexed(String str,int i) {
        return (str.charAt(i) >= '0' && str.charAt(i) <= '9');
    }

}

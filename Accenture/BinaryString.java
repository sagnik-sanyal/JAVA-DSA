public class BinaryString {

    // Question not completed
    public static void main(String[] args) {
        System.out.println(operationsBinaryString("1C0C1C1A0B1"));
    }

    // String consists of binaryDigits eparted with alphabets
    // - A denotes AND operation, -B denotes OR -C denotes XOR
    public static int operationsBinaryString(String str) {
        if (str == null || str.isEmpty()) return -1;
        int i = str.length() - 1;
        int result = Character.getNumericValue(str.charAt(i));
        while (i > 0) {
            final char c = str.charAt(i - 1);
            result = performOperations(c, result,  Character.getNumericValue(str.charAt(i-2)));
            i -= 2;
        }
        return result;
    }

    public static int performOperations(char c, int a, int b) {
        return switch (c) {
            case 'A' -> a & b;
            case 'B' -> a | b;
            default -> a ^ b;
        };
    }

}

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] values = {1, -2, 4, -4, 9, -6, 16, -8, 25, -10};
        double ans = average(values);
        // System.out.println(ans);
        String[] palStrings = {"alpha", "beta", "gamma", "delta", "gamma", "beta", "alpha"};

        boolean bool = isPalindrome(palStrings);
        System.out.println(bool);

    }


    private static double average(int[] values) {
        double sum = 0;
        double total = 0;
        for (int i : values) {
            sum += i;
            total += 1;
        }
        double avg = sum/total;
        return avg;
    }

    private static boolean isPalindrome(String[] palStrings) {
        boolean bool = false;
        int len = palStrings.length;
        String[] copyPalStrings = new String[len];
        for (String str : palStrings) {
            len--;
            copyPalStrings[len] = str;
        }
        if (Arrays.equals(copyPalStrings, palStrings)) {
            bool = true;
            return bool;
        }
        return bool;
    }
}

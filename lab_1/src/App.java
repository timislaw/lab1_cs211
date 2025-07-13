import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

    Janitor emp = new Janitor();
    System.out.println("Salary: " + emp.getSalary());
    System.out.println("Hours: " + emp.getHours());
    System.out.println("Vacation Days: " + emp.getVacationDays());
    emp.clean();
    }

    private static double average(int[] values) {
        double sum = 0;
        double total = 0;
        for (int i : values) {
            sum += i;
            total += 1;
        }
        double avg = sum / total;
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

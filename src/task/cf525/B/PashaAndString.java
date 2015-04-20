package task.cf525.B;

import java.util.Scanner;

/**
 * @author Michael Spitsin
 * @since 2015-04-16
 */
public class PashaAndString {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialString = scanner.next();
        int daysCount = scanner.nextInt();

        System.out.println(new PashaAndString().solve(scanner, initialString, daysCount));
    }

    private String solve(Scanner scanner, String initialString, int daysCount) {
        int[] counters = new int[initialString.length() / 2];

        for(int i = 0; i < daysCount; i++) {
            counters[scanner.nextInt() - 1]++;
        }

        char[] currentString = initialString.toCharArray();
        char p;
        int sum = 0;
        for (int i = 0; i < counters.length; i++) {
            sum += counters[i];
            if (sum % 2 != 0) {
                p = currentString[i];
                currentString[i] = currentString[currentString.length - i - 1];
                currentString[currentString.length - i - 1] = p;
            }
        }

        return new String(currentString);
    }
}

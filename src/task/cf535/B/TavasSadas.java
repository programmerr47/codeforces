package task.cf535.B;

import java.util.Scanner;

/**
 * @author Michael Spitsin
 * @since 2015-04-15
 */
public class TavasSadas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String luckyNumber = scanner.next();

        System.out.println(new TavasSadas().solve(luckyNumber));
    }

    private int solve(String luckyNumber) {
        String binaryNumber = luckyNumber.replace('4', '0').replace('7', '1');
        int prev = binaryNumber.length();
        return Integer.parseInt(binaryNumber, 2) + 1 + ((int)Math.pow(2, prev) - 2);
    }
}

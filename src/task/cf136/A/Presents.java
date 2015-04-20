package task.cf136.A;

import java.util.Scanner;

/**
 * @author Michael Spitsin
 * @since 2015-04-16
 */
public class Presents {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int friendsCount = scanner.nextInt();

        System.out.println(arrayToString(new Presents().solve(scanner, friendsCount)));
    }

    private static String arrayToString(int[] array) {
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for(int item : array) {
            if (first) {
                first = false;
            } else {
                builder.append(" ");
            }

            builder.append(item);
        }

        return builder.toString();
    }

    private int[] solve(Scanner scanner, int friendsCount) {
        int[] result = new int[friendsCount];

        for (int i = 0; i < friendsCount; i++) {
            result[scanner.nextInt() - 1] = i + 1;
        }

        return result;
    }
}

package task.cf525.C;

import java.util.Scanner;

/**
 * @author Michael Spitsin
 * @since 2015-04-20
 */
public class IlyaAndSticks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(new IlyaAndSticks().solve(scanner, n));
    }

    private int[] counters = new int[1000000 + 1];
    private int minLength = 1000000 + 1;
    private int maxLength = 0;

    private long solve(Scanner scanner, int stickCount) {
        for(int i = 0; i < stickCount; i++) {
            int nextStick = scanner.nextInt();
            counters[nextStick]++;

            if (nextStick > maxLength) {
                maxLength = nextStick;
            }

            if (nextStick < minLength) {
                minLength = nextStick;
            }
        }

        long length = -1;
        long width = -1;
        long result = 0;

        for (int i = maxLength; i > minLength - 1; i--) {
            if (counters[i] > 1) {
                counters[i] -= 2;

                if (length == -1) {
                    length = i;
                } else {
                    width = i;
                }
                i++;
            } else if (counters[i] > 0 && counters[i - 1] > 0) {
                counters[i]--;
                counters[i - 1]--;

                if (length == -1) {
                    length = i - 1;
                } else {
                    width = i - 1;
                }
            }

            if (length != -1 && width != -1) {
                result += length * width;
                length = -1;
                width = -1;
            }
        }

        return result;
    }
}

package task.cf525.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Michael Spitsin
 * @since 2015-04-15
 */
public class Task {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfRooms = scanner.nextInt();
        String roomAndKeyMap = scanner.next();
        StringBuilder map = new StringBuilder(roomAndKeyMap);

        System.out.println(new Task().solve(map));
    }

    private int solve(StringBuilder map) {

        int additionalKeys = 0;
        int[] keys = new int[1000];

        for(int i = 0; i < map.length(); i++) {
            char strChar = map.charAt(i);

            if (strChar >= 'a' && strChar <= 'z') {
                keys[strChar]++;
            } else {
                char lower = Character.toLowerCase(strChar);
                if (keys[lower] != 0) {
                    keys[lower]--;
                } else {
                    additionalKeys++;
                }
            }
        }

        return additionalKeys;
    }
}

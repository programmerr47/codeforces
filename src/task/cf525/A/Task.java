package task.cf525.A;

import java.util.Scanner;

/**
 * @author Michael Spitsin
 * @since 2015-04-15
 */

//TODO need to improve
public class Task {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfRooms = scanner.nextInt();
        String roomAndKeyMap = scanner.next();
        StringBuilder map = new StringBuilder(roomAndKeyMap);

        System.out.println(new Task().solve(map));
    }

    private int mAdditionalKeys = 0;

    private int solve(StringBuilder map) {
        for(int i = 0; i < map.length(); i++) {
            char strChar = map.charAt(i);
            char uppercaseChar = Character.toUpperCase(map.charAt(i));

            if (strChar == uppercaseChar) {
                return solveForDoor(map, i);
            }
        }

        return mAdditionalKeys;
    }

    private int solveForDoor(StringBuilder map, int indexOfCurrentDoor) {
        char doorName = Character.toLowerCase(map.charAt(indexOfCurrentDoor));
        for (int i = 0; i < indexOfCurrentDoor; i++) {
            if (doorName == map.charAt(i)) {
                return solve(map.deleteCharAt(indexOfCurrentDoor).deleteCharAt(i));
            }
        }

        mAdditionalKeys++;
        return solve(map.deleteCharAt(indexOfCurrentDoor));
    }
}

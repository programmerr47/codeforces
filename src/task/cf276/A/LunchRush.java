package task.cf276.A;

import java.util.Scanner;

/**
 * @author Michael Spitsin
 * @since 2015-04-15
 */
public class LunchRush {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfRestaurants = scanner.nextInt();
        int timeUpBorder = scanner.nextInt();

        System.out.println(new LunchRush().getAllData(scanner, countOfRestaurants, timeUpBorder));
    }

    private int maxSatisfaction;

    private int getAllData(Scanner scanner, int countOfRestaurants, int timeUpBorder) {
        for (int i = 0; i < countOfRestaurants; i++) {
            getNextRestaurant(scanner, timeUpBorder, i == 0);
        }

        return maxSatisfaction;
    }

    private void getNextRestaurant(Scanner scanner, int timeUpBorder, boolean firstTime) {
        int satisfaction = scanner.nextInt();
        int timeToEat = scanner.nextInt();
        int restaurantSatisfaction = timeToEat > timeUpBorder ? satisfaction - (timeToEat - timeUpBorder) : satisfaction;

        if (firstTime || restaurantSatisfaction > maxSatisfaction) {
            maxSatisfaction = restaurantSatisfaction;
        }
    }
}

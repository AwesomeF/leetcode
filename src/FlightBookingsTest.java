import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlightBookingsTest {

    private FlightBookings flightBookings = new FlightBookings();

    @Test
    void corpFlightBookings() {
        int[] record1 = new int[]{1, 2, 10};
        int[] record2 = new int[]{2, 3, 20};
        int[] record3 = new int[]{2, 5, 25};
        int[][] bookings = new int[][]{record1, record2, record3};
        int n = 5;
        int[] result = flightBookings.corpFlightBookings(bookings, n);
        Arrays.stream(result).forEach(System.out::println);
    }
}
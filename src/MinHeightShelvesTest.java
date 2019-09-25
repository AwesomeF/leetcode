import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinHeightShelvesTest {

    private final MinHeightShelves minHeightShelves = new MinHeightShelves();

    @Test
    void minHeightShelves() {
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int selfWidth = 4;
        assertEquals(6, minHeightShelves.minHeightShelves(books, selfWidth));
    }
}
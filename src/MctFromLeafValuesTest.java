import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MctFromLeafValuesTest {

    MctFromLeafValues mctFromLeafValues = new MctFromLeafValues();

    @Test
    void mctFromLeafValues() {
//        int[] input = new int[] {6,2,4};
        int[] input = new int[] {6,4,2};
        System.out.println(mctFromLeafValues.mctFromLeafValues(input));
    }
}
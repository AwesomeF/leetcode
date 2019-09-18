import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateH2OTest {

    GenerateH2O generateH2O = new GenerateH2O();

    @Test
    void generateH2OTest() {
        int n = 5;
        new Thread(() -> {
            for (int i = 0; i < 2 * n; i++) {
                try {
                    generateH2O.generateHydrogen(() -> System.out.println("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    generateH2O.generateOxygen(() -> System.out.println("O"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
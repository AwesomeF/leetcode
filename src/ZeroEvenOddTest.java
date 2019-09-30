import org.junit.jupiter.api.Test;

class ZeroEvenOddTest {

    @Test
    public void testNWith2() {
        int n = 500;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        new Thread(
                () -> {
                    try {
                        zeroEvenOdd.zero(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
        new Thread(
                () -> {
                    try {
                        zeroEvenOdd.odd(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
        new Thread(
                () -> {
                    try {
                        zeroEvenOdd.even(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }

}
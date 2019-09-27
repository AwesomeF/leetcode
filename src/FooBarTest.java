import org.junit.jupiter.api.Test;

class FooBarTest {


    @Test
    public void test() {
        int loop = 5;
        FooBar fooBar = new FooBar(loop);

        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

}
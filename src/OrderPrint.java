import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * CountDownLatch
 */
public class OrderPrint {

    private CountDownLatch countDownLatch1 = new CountDownLatch(1);
    private CountDownLatch countDownLatch2 =  new CountDownLatch(1);

    public OrderPrint() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

/**
 * Semaphore
 */

//public class OrderPrint {
//
//    private Semaphore twoS = new Semaphore(0);
//    private Semaphore threeS = new Semaphore(0);
//
//    public OrderPrint() {
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        twoS.release();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        twoS.acquire();
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        threeS.release();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        threeS.acquire();
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
//}

/**
 * synchronized
 */

//public class OrderPrint {
//
//    private boolean firstFinished;
//    private boolean secondFinished;
//    private final Object lock = new Object();
//
//    public OrderPrint() {
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        synchronized (lock) {
//            // printFirst.run() outputs "first". Do not change or remove this line.
//            printFirst.run();
//            firstFinished = true;
//            lock.notifyAll();
//        }
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//
//        synchronized (lock) {
//            while (!firstFinished) {
//                lock.wait();
//            }
//            // printSecond.run() outputs "second". Do not change or remove this line.
//            printSecond.run();
//            secondFinished = true;
//            lock.notifyAll();
//        }
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        synchronized (lock) {
//            while (!secondFinished) {
//                lock.wait();
//            }
//            // printThird.run() outputs "third". Do not change or remove this line.
//            printThird.run();
//
//        }
//    }
//}
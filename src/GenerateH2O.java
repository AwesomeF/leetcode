import java.util.concurrent.Semaphore;

public class GenerateH2O {

    private Semaphore s1, s2, s3, s4;

    public GenerateH2O() {
        s1 = new Semaphore(2); // H线程信号量
        s2 = new Semaphore(1); // O线程信号量

        s3 = new Semaphore(0); // 反应条件信号量
        s4 = new Semaphore(0); // 反应条件信号量
    }


    public void generateHydrogen(Runnable releaseHydrogen) throws InterruptedException {
        s1.acquire(); // 保证只有2个H线程进入执行
        s3.release(); // 释放H原子到达信号
        s4.acquire(); // 等待O原子到达
        releaseHydrogen.run();
        s1.release(); // 相当于唤醒1个H线程
    }

    public void generateOxygen(Runnable releaseOxygen) throws InterruptedException {
        s2.acquire(); // 保证只有1个O线程进入执行
        s4.release(2); // 释放O原子到达信号，因为有2个H线程等待所以释放2个
        s3.acquire(2); // 等待H原子到达，2个原因同上
        releaseOxygen.run();
        s2.release(); // 相当于唤醒1个O线程
    }

}

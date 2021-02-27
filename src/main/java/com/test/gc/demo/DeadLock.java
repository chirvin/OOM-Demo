package com.test.gc.demo;

import com.test.gc.util.MyThreadPool;
import java.util.concurrent.ExecutorService;

/**
 * @author sangcongcong
 * @date 2021/2/27 15:32
 */
public class DeadLock {

    public static void main(String[] args) {
        lockTest();
    }

    private static void lockTest() {
        Object o1 = new Object();
        Object o2 = new Object();
        ExecutorService threadPool = MyThreadPool.getThreadPool();
        threadPool.execute(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
                synchronized (o2) {
                    System.out.println("deadLock-1");
                }
            }
        });

        threadPool.execute(() -> {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }
                synchronized (o1) {
                    System.out.println("deadLock-2");
                }
            }
        });
    }
}

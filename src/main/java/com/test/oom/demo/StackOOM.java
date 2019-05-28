package com.test.oom.demo;

/**
 * @author sangcongcong
 * @date 2019/5/28 19:38
 *
 * VM options : -Xss2M
 *
 * 运行结果：java.lang.OutOfMemoryError: unable to create new native thread
 *
 */
public class StackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        StackOOM stackOOM = new StackOOM();
        stackOOM.stackLeakByThread();
    }
}

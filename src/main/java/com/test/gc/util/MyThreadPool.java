package com.test.gc.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author sangcongcong
 * @date 2021/2/27 15:53
 */
public class MyThreadPool {

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setNameFormat("gc-thread-%d").build();

    private static ExecutorService threadPool = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1024),
            threadFactory,new ThreadPoolExecutor.AbortPolicy());

    public static ExecutorService getThreadPool() {
        return threadPool;
    }
}

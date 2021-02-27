package com.test.gc.demo;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

/**
 * @author sangcongcong
 * @date 2019/5/28 20:24
 *
 * VM options : -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * 运行结果：java.lang.OutOfMemoryError: sun.misc.Unsafe.allocateMemory(Native Method)
 */
public class DirectMemoryOOM {

    private static final int ME= 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(ME);
        }
    }
}

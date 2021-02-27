package com.test.gc.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sangcongcong
 * @date 2019/5/28 20:17
 *
 * 1、JVM1.7
 *
 * VM options : -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 运行结果：java.lang.OutOfMemoryError: PermGen space
 *
 * 2、JVM1.8
 *
 * VM options : -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 *
 * 运行结果：java.lang.OutOfMemoryError: GC overhead limit exceeded
 *
 */
public class ConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}

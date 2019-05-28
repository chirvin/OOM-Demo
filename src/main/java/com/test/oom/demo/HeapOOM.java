package com.test.oom.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sangcongcong
 * @date 2019/5/28 18:33
 *
 * VM options : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * 运行结果：java.lang.OutOfMemoryError: Java heap space
 *
 *  /**
 *  @author ${USER}
 *  @date ${DATE} ${TIME}
 *  /
 *
 */
public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}

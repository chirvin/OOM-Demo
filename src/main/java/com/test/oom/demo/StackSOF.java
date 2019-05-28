package com.test.oom.demo;

/**
 * @author sangcongcong
 * @date 2019/5/28 19:30
 *
 * VM options : -Xss128k
 *
 * 运行结果：java.lang.StackOverflowError
 */
public class StackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        StackSOF stackSOF = new StackSOF();
        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length :" + stackSOF.stackLength);
            throw e;
        }
    }
}

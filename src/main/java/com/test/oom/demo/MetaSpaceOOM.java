package com.test.oom.demo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sangcongcong
 * @date 2019/5/28 20:39
 *
 * VM options : -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M -XX:+PrintFlagsInitial
 *
 * 运行结果：java.lang.OutOfMemoryError: Metaspace
 *
 */
public class MetaSpaceOOM {

    static class OOMObject {}

    public static void main(String[] args) {
        int i = 0;

        try {
            for (;;) {
                i++;

                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMObject.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        return proxy.invokeSuper(obj, args);
                    }
                });
                enhancer.create();
            }
        } catch (Exception e) {
            System.out.println("第" + i + "次时发生异常");
            e.printStackTrace();
        }
    }

}

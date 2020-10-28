package innopolis.lesson5;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ADivaev on 28.10.2020.
 */
public class MyClassInitializer {

    public void testProxy(String methodText) {
        Object proxyObject = getProxyObject();
        ((Worker)proxyObject).doWork();
    }

    private Object getProxyObject() {
        final MyClassLoader classLoader = new MyClassLoader();
        Class[] interfaces = {Worker.class};
        InvocationHandler myHandler = new InvocationHandler() {
            SomeClass someClass = new SomeClass();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                method.invoke(someClass,args);
                return null;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,myHandler);
    }
}

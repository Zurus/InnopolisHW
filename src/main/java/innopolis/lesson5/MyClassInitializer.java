package innopolis.lesson5;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ADivaev on 28.10.2020.
 */
public class MyClassInitializer {
    private final static String className = MyClassInitializer.class.getPackage().getName()+".SomeClass";

    public void testProxy(File file) {
        try {
            Class clazz = new MyClassLoader().getClassByFile(file);
            ((Worker)clazz.newInstance()).doWork();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

//    private Object getProxyObject() {
//        final MyClassLoader classLoader = new MyClassLoader();
//        Class[] interfaces = {Worker.class};
//        InvocationHandler myHandler = new InvocationHandler() {
//            SomeClass someClass = new SomeClass();
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                method.invoke(someClass,args);
//                return null;
//            }
//        };
//        return Proxy.newProxyInstance(classLoader,interfaces,myHandler);
//    }
}

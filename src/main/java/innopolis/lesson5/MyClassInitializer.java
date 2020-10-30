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


    public void TestName () {
        System.out.println(className);
        //System.out.println(SomeClass.class.getName());
    }

    public void LoadClass () {
        try {
            //String className = MyClassInitializer.class.getName();
            String className = MyClassInitializer.className;
            Class.forName(className);
            System.out.println();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testProxy(File file) {
        try {
            Object proxyObject =  Class.forName(className).newInstance();// new MyClassLoader().getClassByFile(file);
            ((Worker)proxyObject).doWork();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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

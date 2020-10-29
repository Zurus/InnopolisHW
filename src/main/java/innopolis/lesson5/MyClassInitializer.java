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
        try {
            Object proxyObject = getProxyObject();
            ((Worker)proxyObject).doWork();
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден!");
        } catch (IllegalAccessException e) {
            System.out.println("Что - то с доступом!");
        } catch (InstantiationException e) {
            System.out.println("Ошибка инициализации");
        }
    }

    private Object getProxyObject() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
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

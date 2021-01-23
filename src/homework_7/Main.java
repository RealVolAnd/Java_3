package homework_7;

import javax.management.ObjectName;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static MyTest myTest;

    public static void main(String[] args) {
        myTest = new MyTest();
        Class c = myTest.getClass();
        start(c);
    }

    public static void start(Class c) {

        Method[] methods = c.getDeclaredMethods();
        Method beforeSuitMethod = null;
        Method afterSuitMethod = null;
        List<Method> testMethods = new LinkedList<>();


        int beforeSuitCounter = 0;
        int afterSuitCounter = 0;
        int testCounter = 0;

        for (Method method : methods) {
            if (method.getAnnotation(Anno.BeforeSuite.class) != null) {
                beforeSuitMethod = method;
                beforeSuitCounter++;
            }
            if (method.getAnnotation(Anno.AfterSuite.class) != null) {
                afterSuitMethod = method;
                afterSuitCounter++;
            }
            Annotation annotation = method.getAnnotation(Anno.Test.class);
            if (annotation != null) {
                //  testMethods.add(method, ((Anno.Test) annotation).priority());
                testMethods.add(method);
                testCounter++;
            }
        }

        if (beforeSuitCounter != 1)
            throw new RuntimeException("Количество BeforeSuite не равно 1 (" + beforeSuitCounter + ")");
        if (afterSuitCounter != 1)
            throw new RuntimeException("Количество AfterSuite не равно 1(" + afterSuitCounter + ")");
        if (testCounter == 0)
            throw new RuntimeException("Отсутствуют методы с аннотацией Test");

        Collections.sort(testMethods, Comparator.comparingInt(obj -> {
            Annotation annotation = obj.getAnnotation(Anno.Test.class);
            return ((Anno.Test) annotation).priority();
        }));

        runBeforeSuit(beforeSuitMethod);
        runTestSuit(testMethods);
        runAfterSuit(afterSuitMethod);
    }

    private static void runBeforeSuit(Method method) {
        try {
            method.invoke(myTest);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void runTestSuit(List<Method> testMethods) {
        for (Method testMethod : testMethods) {
            try {
                testMethod.invoke(myTest);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private static void runAfterSuit(Method method) {
        try {
            method.invoke(myTest);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

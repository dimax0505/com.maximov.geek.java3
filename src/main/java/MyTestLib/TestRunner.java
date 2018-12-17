package MyTestLib;

import MyTestCase.TestOfTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestRunner {

    public static void main(String[] args) throws Exception {
        start(TestOfTest.class);

    }

    private static void start(Class<?> testClass) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor constructor = testClass.getConstructor();
        Object instance = constructor.newInstance();
        Method methodFirst = PrepareAndFinish(testClass, BeforeSuite.class);
        if (methodFirst != null) {
            methodFirst.invoke(instance);
        }

        List<Method> methodsTest = Arrays.stream(testClass.getDeclaredMethods()).filter(method -> method.isAnnotationPresent(Test.class)).
                sorted(Comparator.comparingInt((Method i) -> i.getAnnotation(Test.class).priority().getPriority())).collect(Collectors.toList());

        for (Method test : methodsTest) {
            test.invoke(instance);
        }
        Method methodEnd = PrepareAndFinish(testClass, AfterSuite.class);
        if (methodEnd != null) {
            methodEnd.invoke(instance);
        }

    }


    private static Method PrepareAndFinish(Class<?> testClass, Class<? extends Annotation> annotate) {

        if (testClass.getDeclaredAnnotationsByType(annotate).length > 1)
            throw new RuntimeException(annotate.getName() + " is not unique");
        for (Method methods : testClass.getDeclaredMethods()) {
            if (methods.getAnnotationsByType(annotate).length == 1) return methods;
        }
        return null;
    }

}

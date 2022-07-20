import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)  {

        Class reflectionClass = Reflection.class;

        Method[] declaredMethods = reflectionClass.getDeclaredMethods();

        Arrays.stream(declaredMethods).
                filter(s -> s.getName().startsWith("get")).
                sorted(Comparator.comparing(Method::getName)).
                forEach(s -> System.out.printf("%s will return class %s%n", s.getName(), s.getReturnType().getName()));

        Arrays.stream(declaredMethods).
                filter(s -> s.getName().startsWith("set")).
                sorted(Comparator.comparing(Method::getName)).
                forEach(s -> System.out.printf("%s and will set field of class %s%n", s.getName(), s.getParameterTypes()[0].getName()));
    }
}
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)  {

        Class reflectionClass = Reflection.class;

        Field[] declaredFields = reflectionClass.getDeclaredFields();

        Arrays.stream(declaredFields).
                filter(s -> !Modifier.isPrivate(s.getModifiers())).
                sorted(Comparator.comparing(Field::getName)).
                forEach(s -> System.out.printf("%s must be private!%n", s.getName()));

        Method[] declaredMethods = reflectionClass.getDeclaredMethods();

        Arrays.stream(declaredMethods).
                filter(s -> s.getName().startsWith("get") && !Modifier.isPublic(s.getModifiers())).
                sorted(Comparator.comparing(Method::getName)).
                forEach(s -> System.out.printf("%s have to be public!%n", s.getName()));

        Arrays.stream(declaredMethods).
                filter(s -> s.getName().startsWith("set") && !Modifier.isPrivate(s.getModifiers())).
                sorted(Comparator.comparing(Method::getName)).
                forEach(s -> System.out.printf("%s have to be private!%n", s.getName()));
    }
}
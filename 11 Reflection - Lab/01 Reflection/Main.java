import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> reflectionClass = Reflection.class;

        System.out.println(reflectionClass);

        System.out.println(reflectionClass.getSuperclass());

        Class<?>[] interfaces = reflectionClass.getInterfaces();

        Arrays.stream(interfaces).forEach(System.out::println);

        Object reflectionNewInstance = reflectionClass.getDeclaredConstructor().newInstance();

        System.out.println(reflectionNewInstance);
    }
}

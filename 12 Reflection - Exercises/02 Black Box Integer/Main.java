package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final static Scanner CONSOLE = new Scanner(System.in);
    private final static String END_COMMAND = "END";
    private final static Map<String, Method> blackBoxIntMethods =
            Arrays.stream(BlackBoxInt.class.getDeclaredMethods()).
                    peek(method -> method.setAccessible(true)).
                    collect(Collectors.toMap(Method::getName, method -> method));


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        final Constructor<?> constructor = BlackBoxInt.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance(0);

        Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String command;

        while (!END_COMMAND.equals(command = CONSOLE.nextLine())) {
            String[] attributes = command.split("_");
            String methodFromConsole = attributes[0];
            Integer value = Integer.parseInt(attributes[1]);

            Method method = blackBoxIntMethods.get(methodFromConsole);
            method.invoke(blackBoxInt, value);

            System.out.println(innerValue.getInt(blackBoxInt));
        }

        CONSOLE.close();
    }
}
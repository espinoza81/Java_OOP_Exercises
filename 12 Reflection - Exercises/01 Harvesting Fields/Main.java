package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		final String PRINT = "%s %s %s%n"; //{access modifier} {field type} {field name}
		Scanner console = new Scanner(System.in);
		String command;

		Class reflectionClass = RichSoilLand.class;

		Field[] declaredFields = reflectionClass.getDeclaredFields();

		while (!"HARVEST".equals(command = console.nextLine())) {

			switch (command) {
				case "private":
					Arrays.stream(declaredFields).
							filter(s -> Modifier.isPrivate(s.getModifiers())).
							forEach(getFieldConsumer(PRINT));
					break;
				case "protected":
					Arrays.stream(declaredFields).
							filter(s -> Modifier.isProtected(s.getModifiers())).
							forEach(getFieldConsumer(PRINT));
					break;
				case "public":
					Arrays.stream(declaredFields).
							filter(s -> Modifier.isPublic(s.getModifiers())).
							forEach(getFieldConsumer(PRINT));
					break;
				case "all":
					Arrays.stream(declaredFields).
							forEach(getFieldConsumer(PRINT));
					break;
			}
		}
	}

	private static Consumer<Field> getFieldConsumer(String PRINT) {
		return s -> System.out.printf(PRINT, Modifier.toString(s.getModifiers()), s.getType().getSimpleName(), s.getName());
	}
}

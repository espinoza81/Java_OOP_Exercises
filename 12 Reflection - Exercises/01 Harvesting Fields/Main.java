package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

	private final static String PRINT = "%s %s %s%n"; //{access modifier} {field type} {field name}
	private final static String END_COMMAND = "HARVEST";
	private final static String PRIVATE = "private";
	private final static String PROTECTED = "protected";
	private final static String PUBLIC = "public";
	private final static Scanner CONSOLE = new Scanner(System.in);
	private final static Field[] declaredFields = RichSoilLand.class.getDeclaredFields();

	public static void main(String[] args) {

		String command;

		while (!END_COMMAND.equals(command = CONSOLE.nextLine())) {

			switch (command) {
				case PRIVATE:
					filterFieldsModifier(PRIVATE);
					break;

				case PROTECTED:
					filterFieldsModifier(PROTECTED);
					break;

				case PUBLIC:
					filterFieldsModifier(PUBLIC);
					break;

				case "all":
					Arrays.stream(declaredFields).
							forEach(getFieldConsumer());
					break;
			}
		}

		CONSOLE.close();
	}

	private static void filterFieldsModifier(String aPrivate) {

		Arrays.stream(declaredFields).
				filter(s -> Modifier.toString(s.getModifiers()).equals(aPrivate)).
				forEach(getFieldConsumer());
	}

	private static Consumer<Field> getFieldConsumer() {

		return s -> System.out.printf(PRINT, Modifier.toString(s.getModifiers()), s.getType().getSimpleName(), s.getName());
	}
}
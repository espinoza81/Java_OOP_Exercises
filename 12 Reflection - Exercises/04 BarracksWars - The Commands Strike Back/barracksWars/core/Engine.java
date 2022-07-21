package barracksWars.core;

import barracksWars.interfaces.*;
import barracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
	private static final String COMMAND_PACKAGE_NAME = "barracksWars.core.commands.";

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String commandClass = commandName.toUpperCase().charAt(0) + commandName.substring(1);

		Class<?> reflection = null;

		try {
			reflection = Class.forName(COMMAND_PACKAGE_NAME + commandClass);
		} catch (ClassNotFoundException e) {
			return "Invalid command!";
		}

		Constructor<?> constructor = reflection.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);

		Executable command = (Executable) constructor.newInstance(data, this.repository, this.unitFactory);

//		switch (commandName) {
//			case "add":
//				result = this.addUnitCommand(data);
//				break;
//			case "report":
//				result = this.reportCommand(data);
//				break;
//			case "fight":
//				result = this.fightCommand(data);
//				break;
//			default:
//				throw new RuntimeException("Invalid command!");
//		}

		return command.execute();
	}

	private String reportCommand(String[] data) {
		String output = this.repository.getStatistics();
		return output;
	}

	private String addUnitCommand(String[] data) throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		String unitType = data[1];
		Unit unitToAdd = this.unitFactory.createUnit(unitType);
		this.repository.addUnit(unitToAdd);
		String output = unitType + " added!";
		return output;
	}
	
	private String fightCommand(String[] data) {
		return "fight";
	}
}

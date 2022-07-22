package barracksWars.core;

import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

	private final String END_COMMAND = "fight";

	private final CommandInterpreter commandInterpreter;

	public Engine(CommandInterpreter commandInterpreter) {
		this.commandInterpreter = commandInterpreter;
	}

	@Override
	public void run() throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input;

		while (!END_COMMAND.equals(input = reader.readLine())) {

			try {
				String[] data = input.split("\\s+");

				final String commandName = data[0];

				Executable executable = this.commandInterpreter.interpretCommand(data, commandName);

				String result = executable.execute();

				System.out.println(result);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
}
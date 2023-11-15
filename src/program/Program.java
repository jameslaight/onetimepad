package program;

import main.Fight;

public abstract class Program {

	protected final Fight fight;
	private final String name, usage;

	public Program(Fight fight, String name, String usage) {
		this.fight = fight;
		this.name = name;
		this.usage = usage;
	}

	public String getName() {
		return name;
	}

	public String getUsage() {
		return name + " " + usage;
	}

	public abstract Result execute(String[] args); //returns whether successful

	public record Result(boolean success, String message) {}

}

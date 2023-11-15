package program;

import main.Fight;

public abstract class Program {

	protected final Fight fight;
	private final String name, usage;
	private final boolean oneTimeUse;

	public Program(Fight fight, boolean oneTimeUse, String name, String usage) {
		this.fight = fight;
		this.oneTimeUse = oneTimeUse;
		this.name = name;
		this.usage = usage;
	}

	public String getName() {
		return name;
	}

	public String getUsage() {
		return name + " " + usage;
	}

	public boolean isOneTimeUse() {
		return oneTimeUse;
	}

	public abstract Result execute(String[] args); //returns whether successful

	public record Result(boolean success, String message) {}

}

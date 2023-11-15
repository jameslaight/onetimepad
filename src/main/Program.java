package main;

public abstract class Program {

	protected final Fight fight;
	private final String name;

	public Program(Fight fight, String name) {
		this.fight = fight;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract boolean execute(String[] args); //returns whether successful

}

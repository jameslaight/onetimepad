package main;

public abstract class Program {

	private final String name;

	public Program(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract boolean execute(String[] args); //returns whether successful

}

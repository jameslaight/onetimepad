package main;

import program.Help;
import program.Program;
import program.X;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fight {

	private final int level;
	private final Clip clip;
	private final Gate gate;

	private final List<Program> programs = new ArrayList<>();

	public Fight(int level) {
		this.level = level;

		clip = new Clip();
		gate = new Gate(level - 1);

		programs.add(new X(this));
		programs.add(new Help(this));
	}

	public int getLevel() {
		return level;
	}

	public Clip getClip() {
		return clip;
	}

	public Gate getGate() {
		return gate;
	}

	public List<Program> getPrograms() {
		return Collections.unmodifiableList(programs);
	}

	public void addProgram(Program program) {
		programs.add(program);
	}

	public void removeProgram(Program program) {
		programs.remove(program);
	}

}

package main;

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

}

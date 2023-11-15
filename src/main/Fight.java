package main;

public class Fight {

	private final int level;
	private final Clip clip;
	private final Gate gate;

	public Fight(int level) {
		this.level = level;

		clip = new Clip();
		gate = new Gate(level - 1);
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

}

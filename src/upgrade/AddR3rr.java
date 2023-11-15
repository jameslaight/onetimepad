package upgrade;

import main.Fight;
import program.R3rr;

public class AddR3rr extends Upgrade {

	@Override
	public String getName() {
		return "r3rr";
	}

	@Override
	public String getDescription() {
		return "(program) acts like program x, without limitation of [c] being in [word]";
	}

	@Override
	public void apply(Fight fight) {
		fight.addProgram(new R3rr(fight));
	}

}

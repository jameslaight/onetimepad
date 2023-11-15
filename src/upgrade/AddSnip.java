package upgrade;

import main.Fight;
import program.Snip;

public class AddSnip extends Upgrade {

	@Override
	public String getName() {
		return "snip";
	}

	@Override
	public String getDescription() {
		return "(program) expends one character in the clip to destroy one in the gate";
	}

	@Override
	public void apply(Fight fight) {
		fight.addProgram(new Snip(fight));
	}

}

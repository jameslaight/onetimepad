package upgrade;

import main.Fight;
import program.Mu2t;

public class AddMu2t extends Upgrade {

	@Override
	public String getName() {
		return "mu2t";
	}

	@Override
	public String getDescription() {
		return "damages the same character based on the length of a word given to it";
	}

	@Override
	public void apply(Fight fight) {
		fight.addProgram(new Mu2t(fight));
	}

}
